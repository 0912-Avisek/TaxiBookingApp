package com.taxi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taxi.Entity.Adminentity;
import com.taxi.Repositary.AdminCurd;

@Service
public class CheckoldcreditImpl implements Checkoldcredit{
	
    @Autowired
	private AdminCurd passjpa;
	

	private PasswordEncoder passwordencoder;
	
	@Autowired
	public void setPasswordencoder(PasswordEncoder passwordencoder) {
		this.passwordencoder = passwordencoder;
	}
	
	@Override
	public String checkoldcredentials(String oldusername, String oldpassword) {
	 
		Optional<Adminentity> olduserdata = passjpa.findByUsername(oldusername);
		
		
		if(olduserdata.isPresent()) {
			
			Adminentity adminentity = olduserdata.get();
			
			String password = adminentity.getPassword();
			
		
			
			if(passwordencoder.matches(oldpassword, password)) {
				return "password Correct";
			}
			else {
				return "password Wrong";
			}
			
			
		}
		else {
			return "Username Wrong";
		}
		
		
	}

	@Override
	public void changepassword(String oldusername, String newusername, String newpassword) {
	  
		Optional<Adminentity> olduserdata = passjpa.findByUsername(oldusername);
		
		String encodenewpassword = passwordencoder.encode(newpassword);
		
		Adminentity adminentity = olduserdata.get();
		
		adminentity.setUsername(newusername);
		adminentity.setPassword(encodenewpassword);
		
		passjpa.save(adminentity);
	}

	

}
