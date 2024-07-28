package com.q2.service;

import com.q2.dtos.ApiResponse;
import com.q2.entities.Reservation;

public interface ReservationService {

	ApiResponse addReservation(Reservation reserve);
	
	ApiResponse deleteReservation(Long id);
}
