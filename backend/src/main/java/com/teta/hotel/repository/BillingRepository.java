package com.teta.hotel.repository;

import com.teta.hotel.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    Optional<Billing> findByBookingId(Long bookingId);
} 