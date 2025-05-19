package com.teta.hotel.controller;

import com.teta.hotel.model.Billing;
import com.teta.hotel.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billings")
@CrossOrigin(origins = "http://localhost:3000")
public class BillingController {
    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<?> getBillingByBookingId(@PathVariable Long bookingId) {
        return billingService.getBillingByBookingId(bookingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
} 