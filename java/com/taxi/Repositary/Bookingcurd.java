package com.taxi.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Entity.BookingEntity;

@Repository
public interface Bookingcurd extends JpaRepository<BookingEntity, Integer>{
	
      
}
