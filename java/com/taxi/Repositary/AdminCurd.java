package com.taxi.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taxi.Entity.Adminentity;
import java.util.Optional;

@Repository
public interface AdminCurd extends JpaRepository<Adminentity, Integer>{
         
	     Optional<Adminentity> findByUsername(String username);
}
