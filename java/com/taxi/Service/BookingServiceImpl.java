package com.taxi.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.DTO.BookingData;
import com.taxi.Entity.BookingEntity;
import com.taxi.Repositary.Bookingcurd;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private Bookingcurd bookingjpa;
	
	@Autowired
	private ModelMapper modelmap;

	@Override
	public BookingEntity bookingDetailsaveDB(BookingData bookingdata) {
		
		BookingEntity bookingentity = modelmap.map(bookingdata, BookingEntity.class);
		
	
		BookingEntity entitysave = bookingjpa.save(bookingentity);
		return entitysave;
		
	}

	@Override
	public List<BookingEntity> databaseTobookingpage() {
		
		List<BookingEntity> listofbookingdetail = bookingjpa.findAll();  

		/*
		 * for(BookingEntity it :listofbookingdetail ) { System.out.println(it); }
		 */
		
		
		return listofbookingdetail;
	}



	

}
