package com.taxi.DTO;



import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookingData {
	
	@NotEmpty(message = "filed cant be empty")
	@NotBlank(message = "filed cant be blank")
	private String name;
	
	@NotEmpty(message = "filed cant be empty")
	@NotBlank(message = "filed cant be blank")
	private String source;
	
	@NotEmpty(message = "filed cant be empty")
	@NotBlank(message = "filed cant be blank")
	private String email;
	
	@NotEmpty(message = "filed cant be empty")
	@NotBlank(message = "filed cant be blank")
	private String destination;
	
	@NotNull(message = "filed cant be empty")
	private LocalTime time;
    @NotNull(message = "filed cant be empty")
	private LocalDate date;
	
	
	@NotEmpty(message = "filed cant be empty")
	@NotBlank(message = "filed cant be blank")
	private String comfort;
	
	@Min(value = 1)
	@Max(value = 4)
	private int adult;
	
	@Max(value = 4)
	private int childern;
	
	@NotEmpty(message = "filed cant be empty")
	@NotBlank(message = "filed cant be blank")
	private String message;
	

}
