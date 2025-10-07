package com.taxi.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.DTO.ContactData;
import com.taxi.Entity.ContactEntity;
import com.taxi.Repositary.Contactcurd;

@Service
public class ContactFormServiceImpl implements ContactFormService {
    
	@Autowired
	private Contactcurd contactjpa;
	@Autowired
	private ModelMapper modelmap;
	@Override
	public ContactEntity contactdataToDB(ContactData condata) {
		
		ContactEntity conEntity = modelmap.map(condata, ContactEntity.class);
		
		ContactEntity save = contactjpa.save(conEntity);
		
		return save;
		
	}
	@Override
	public List<ContactEntity> databasetopage() {
		
		List<ContactEntity> listofcontacts = contactjpa.findAll();
		return listofcontacts;
	}
	@Override
	public void deletecontactdetail(int id) {
		
		 contactjpa.deleteById(id);
	}

}
