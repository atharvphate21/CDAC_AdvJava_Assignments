package com.q2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.q2.custom_exceptions.ResourceNotFoundException;
import com.q2.entities.Reservation;
import com.q2.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addReservation(reservation));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResourceNotFoundException("Room Reservation Error!"));
        }
    }

    @DeleteMapping("/{resId}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long resId) {
        try {
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(reservationService.deleteReservation(resId));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResourceNotFoundException("Room Reservation Error!"));
        }
    }
}