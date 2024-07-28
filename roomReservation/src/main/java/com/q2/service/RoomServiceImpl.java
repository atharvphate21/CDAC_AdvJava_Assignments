package com.q2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.q2.dtos.ApiResponse;
import com.q2.entities.Room;
import com.q2.repository.RoomRepo;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepo repo;
	
	@Override
	public ApiResponse addNewRoom(Room room) {
		repo.save(room);
		return new ApiResponse("Room inserted");
	}

	@Override
	public List<Room> getAvailableRooms() {
		return repo.findByAvailability(true);
	}

	
}
