package com.teta.hotel.service;

import com.teta.hotel.model.Billing;
import com.teta.hotel.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BillingService {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Optional<Billing> getBillingByBookingId(Long bookingId) {
        return billingRepository.findByBookingId(bookingId);
    }
} 