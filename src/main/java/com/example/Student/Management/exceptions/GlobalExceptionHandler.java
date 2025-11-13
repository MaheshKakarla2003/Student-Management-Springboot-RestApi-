package com.example.Student.Management.exceptions;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.Student.Management.dto.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//Handeling cspecific exceptions
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex , WebRequest req){
		
		ApiError error = new ApiError(LocalDateTime.now()
                , "Invalid_request_body", 
                ex.getMessage(), 
                req.getDescription(false), 
                HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ApiError>(error , HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(NotFoundException.class)
	public  ResponseEntity<ApiError> studentNotFoundException(NotFoundException ex , WebRequest req){
		
		ApiError error = new ApiError(LocalDateTime.now()
                , "Student_not_found", 
                ex.getMessage(), 
                req.getDescription(false), 
                HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(error , HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public  ResponseEntity<ApiError> handleConflict(DataIntegrityViolationException ex , WebRequest req){
		
		ApiError error = new ApiError(LocalDateTime.now()
                , "Database constraint violation", 
                 ex.getMessage(), 
                req.getDescription(false), 
                HttpStatus.CONFLICT);
		return new ResponseEntity<ApiError>(error , HttpStatus.CONFLICT);	
	}
	
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public  ResponseEntity<ApiError> typeMisMatch(MethodArgumentTypeMismatchException ex , WebRequest req){
		
		ApiError error = new ApiError(LocalDateTime.now()
                , "type_mis_match", 
                ex.getMessage(), 
                req.getDescription(false), 
                HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<ApiError>(error , HttpStatus.NOT_ACCEPTABLE);	
	}
	//handeling generic exceptions
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<ApiError> handleAll(Exception ex , WebRequest req){
		
		ApiError error = new ApiError(LocalDateTime.now()
                , "Internal_server_error", 
                ex.getMessage(), 
                req.getDescription(false), 
                HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiError>(error , HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
}
