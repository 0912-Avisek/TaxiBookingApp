	package com.taxi.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Booking_Detail")
public class BookingEntity {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    
	private String name;
	
	private String source;
	
	private String email;
	
	private String destination;
	
	private LocalTime time;
	
	private LocalDate date;
	
	private String comfort;
	
	private int adult;
	
	private int childern;
	
	private String message;
	
}
