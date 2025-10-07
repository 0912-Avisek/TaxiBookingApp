package com.taxi.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Entity.ServiceEntity;
@Repository
public interface ImageServiceCurd extends JpaRepository<ServiceEntity, Integer> {
  
	
	
}
