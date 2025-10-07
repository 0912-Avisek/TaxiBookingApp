package com.taxi.Service;

import java.util.List;

import com.taxi.DTO.BookingData;
import com.taxi.Entity.BookingEntity;

public interface BookingService {
	
	BookingEntity bookingDetailsaveDB(BookingData datax);
	
	public List<BookingEntity> databaseTobookingpage();

}
