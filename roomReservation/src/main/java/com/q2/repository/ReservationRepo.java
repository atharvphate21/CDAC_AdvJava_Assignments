package com.q2.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.q2.entities.Reservation;
import com.q2.entities.Room;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    Reservation findByRoomAndCheckInDateAndCheckOutDate(Room room, LocalDate checkInDate, LocalDate checkOutDate);
}