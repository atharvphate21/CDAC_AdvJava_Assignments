package com.q2.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Reservation {
//Reservation ID, guest name, check-in date, check-out date, room ID, total price.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resId")
	private Long resId;
	
	@Column(name = "guestName", length = 20)
	private String guestname;
	
	@Column(name = "checkIn")
	private LocalDate checkInDate; // = LocalDate.now();
	
	@Column(name = "checkOut")
	private LocalDate checkOutDate;
	
	@ManyToOne
	private Room room;
	
	@Column(name = "totalPrice")
	private Double totalPrice;
	
}
