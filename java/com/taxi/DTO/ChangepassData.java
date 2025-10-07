package com.taxi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangepassData {

	private String oldusername;
	private String oldpassword;
	private String newusername;
	private String newpassword;
	
	
}
