package com.example.Student.Management.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

	private LocalDateTime timestamp;
	private String error;
	private  String message;
	private String details;
	private HttpStatus status;
}
