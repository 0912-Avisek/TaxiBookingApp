package com.taxi.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactData {
    
	@NotEmpty(message = "Name cant be empty")
	@Size(min = 3 ,max = 30 ,message = "name minimum size is 3")
	private String name;
	
	@NotNull
	@Min(value = 1000000000 ,message = "minimum size 10 digit")
	@Max(value = 9999999999L, message = "maximum size 10 digit")
	private Long phone;
	
	@NotEmpty(message = "email cant be empty")
	@Size(min = 3 ,max = 30 ,message = "email minimum size is 3")
	private String email;
	
	@NotEmpty(message = "message cant be empty")
	@Size(min = 3 ,max = 50 ,message = "message minimum size is 3")
	private String message;
	
}
