package com.taxi.Service;

public interface Checkoldcredit {
    
	public String checkoldcredentials(String oldusername,String oldpassword);
	
	public void changepassword(String oldusername,String newusername,String newpassword);
}
