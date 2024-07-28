package com.q2.service;

import java.util.List;

import com.q2.dtos.ApiResponse;
import com.q2.entities.Room;

public interface RoomService {
	
	ApiResponse addNewRoom(Room room);
	
	List<Room> getAvailableRooms();

}
