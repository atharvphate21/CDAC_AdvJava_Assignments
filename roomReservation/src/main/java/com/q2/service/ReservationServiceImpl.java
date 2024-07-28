package com.q2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.q2.custom_exceptions.ResourceNotFoundException;
import com.q2.dtos.ApiResponse;
import com.q2.entities.Reservation;
import com.q2.entities.Room;
import com.q2.repository.ReservationRepo;
import com.q2.repository.RoomRepo;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepo repo;
	
	@Autowired
	private RoomRepo roomrepo;

	@Override
	public ApiResponse addReservation(Reservation reserve) {
		Room room = roomrepo.findById(reserve.getRoom().getId()).orElseThrow();
		if(room.getAvailability()==false) {
			throw new ResourceNotFoundException("Room is not available");
		}
		if (repo.findByRoomAndCheckInDateAndCheckOutDate(room, reserve.getCheckInDate(), reserve.getCheckOutDate())!= null) {
            throw new ResourceNotFoundException("Conflicting reservation found");
        }
		room.setAvailability(false);
		roomrepo.save(room);
		repo.save(reserve);
		return new ApiResponse("Reservation successful!!!");
	}

	@Override
	public ApiResponse deleteReservation(Long id) {
		Reservation reservation = repo.findById(id).orElseThrow();
        Room room = reservation.getRoom();
        room.setAvailability(true);
        roomrepo.save(room);
        repo.delete(reservation);
        return new ApiResponse("Reservation successfully deleted!!!");
	}
	
//	@Override
//	public ApiResponse addReservation(Reservation reserve) {
//		if(reserve.getRoom().getAvailability()==true) {
//			repo.save(reserve);
//			Room room = roomrepo.findById(reserve.getRoom().getId()).orElseThrow(()->
//			new ResourceNotFoundException("Cant find room id"));
//			room.setAvailability(false);
//		}
//		return new ApiResponse("Room booked!");
//	}
//
//	@Override
//	public ApiResponse deleteReservation(Long id) {
//		Reservation res = repo.findById(id).orElseThrow(()->
//		new ResourceNotFoundException("Cant find reservation!"));
//		repo.deleteById(id);
//		Room room = roomrepo.findById(res.getRoom().getId()).orElseThrow(()->
//		new ResourceNotFoundException("Cant find room id"));
//		room.setAvailability(true);
//		return new ApiResponse("Reservation deleted!");
//	}

}
