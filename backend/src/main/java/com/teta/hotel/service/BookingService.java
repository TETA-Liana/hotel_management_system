package com.teta.hotel.service;

import com.teta.hotel.model.Booking;
import com.teta.hotel.model.Room;
import com.teta.hotel.repository.BookingRepository;
import com.teta.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public Booking bookRoom(Booking booking) {
        // Check room availability for the given dates
        Room room = booking.getRoom();
        List<Booking> existingBookings = bookingRepository.findByRoomId(room.getId());
        boolean isAvailable = existingBookings.stream().noneMatch(b ->
            b.getStatus() == Booking.Status.CONFIRMED &&
            !(booking.getCheckOut().isBefore(b.getCheckIn()) || booking.getCheckIn().isAfter(b.getCheckOut()))
        );
        if (!isAvailable) {
            throw new RuntimeException("Room is not available for the selected dates");
        }
        booking.setStatus(Booking.Status.CONFIRMED);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            if (booking.getCheckIn().isAfter(LocalDate.now()) && booking.getStatus() == Booking.Status.CONFIRMED) {
                booking.setStatus(Booking.Status.CANCELLED);
                bookingRepository.save(booking);
            } else {
                throw new RuntimeException("Cannot cancel booking that has already started or is not confirmed");
            }
        } else {
            throw new RuntimeException("Booking not found");
        }
    }
} 