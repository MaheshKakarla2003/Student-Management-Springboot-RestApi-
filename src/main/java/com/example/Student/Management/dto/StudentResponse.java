package com.example.Student.Management.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private LocalDate  dob;
	private String branch;
	private int year;
	
}
