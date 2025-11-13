package com.example.Student.Management.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

	@NotBlank(message="please provide firstname") @Size(min=2 ,max=40)
	private String firstName;
	
	@NotBlank(message="please provide lastname") @Size(min=2 ,max=40)
	private String lastName;
	
	@Email @NotBlank
	private String email;
	
	@Pattern( regexp="\\d{10,15}")
	private String phone;
	
	@NotNull
	@Past
	private LocalDate  dob;
	
	private String branch;
	
	@Min(1) @Max(4)
	private int year;
	
}
