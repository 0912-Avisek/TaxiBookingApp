package com.taxi.Service;

import java.util.List;

import com.taxi.DTO.ContactData;
import com.taxi.Entity.ContactEntity;

public interface ContactFormService {

	
	public ContactEntity contactdataToDB(ContactData condata);
	
	public List<ContactEntity> databasetopage();
	
	public void deletecontactdetail(int id);
}
