package com.q2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.q2.entities.Room;
import com.q2.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService serv;
	
	@PostMapping("/add")
	public ResponseEntity<?> addRoom(@RequestBody Room room){
		return ResponseEntity.ok(serv.addNewRoom(room));
	}
	
	@GetMapping("/availabe=yes")
	public ResponseEntity<?> getRoom(){
		return ResponseEntity.ok(serv.getAvailableRooms());
	}
}
