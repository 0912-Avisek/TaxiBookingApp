package com.taxi.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.taxi.Entity.Adminentity;
import com.taxi.Repositary.AdminCurd;

import jakarta.annotation.PostConstruct;

@Service
public class UserdetailServiceImpl implements UserDetailsService{
    
	private AdminCurd adminjpa;
	
	@Autowired
	private PasswordEncoder  passwordencoder;
	

    @Autowired
	public void setAdminjpa(AdminCurd adminjpa) {
		this.adminjpa = adminjpa;
	}
    
    @PostConstruct
    public void init() {
    	
    	long count = adminjpa.count();
    	if(count==0) {
    		Adminentity adminentity = new Adminentity();
    		adminentity.setUsername("Admin");
    		adminentity.setPassword(passwordencoder.encode("admin@123"));
    		
    		adminjpa.save(adminentity);
    		
    	}
    	
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		   Optional<Adminentity> byUsername = adminjpa.findByUsername(username); 
		   
		   Adminentity admindetail =byUsername.orElseThrow(()->new UsernameNotFoundException("Admin does not exit"));
		   
		   UserDetails userDetails = User.withUsername(admindetail.getUsername()).password(admindetail.getPassword()).build();
		   return  userDetails;
		   
	}

}
