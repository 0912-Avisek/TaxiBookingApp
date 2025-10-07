package com.taxi.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxi.Entity.ContactEntity;

@Repository
public interface Contactcurd extends JpaRepository<ContactEntity, Integer> {

}
