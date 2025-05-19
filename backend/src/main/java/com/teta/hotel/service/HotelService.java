package com.teta.hotel.service;

import com.teta.hotel.exception.RoomNotFoundException;
import com.teta.hotel.model.Hotel;
import com.teta.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Hotel not found with id: " + id));
        
        hotel.setName(updatedHotel.getName());
        hotel.setLocation(updatedHotel.getLocation());
        
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new RoomNotFoundException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
    }
} 