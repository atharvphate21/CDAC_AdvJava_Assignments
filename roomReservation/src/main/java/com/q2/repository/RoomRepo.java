package com.q2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.q2.entities.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
	
	List<Room> findByAvailability(Boolean availability);

}
