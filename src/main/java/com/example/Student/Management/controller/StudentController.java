package com.example.Student.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Management.dto.StudentCreateRequest;
import com.example.Student.Management.dto.StudentResponse;
import com.example.Student.Management.dto.StudentUpdateRequest;
import com.example.Student.Management.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private  StudentService  studentService;
	
// adding one student
	@PostMapping("student")
	public ResponseEntity<StudentResponse> addStudent(@Valid @RequestBody StudentCreateRequest req)
	{
		             StudentResponse res= studentService.create(req);
		             return ResponseEntity.status(HttpStatus.CREATED).body(res);	
	}
	
//	adding a group of students as a list
	@PostMapping("students-bulk")
	public String addAllStudents(@Valid @RequestBody  List<StudentCreateRequest> list) {
	
		studentService.addAllStudents(list);
		return "students are added succesfully";
	}
	
//	 fetching one student by id
	@GetMapping("{id}")
	public ResponseEntity<StudentResponse> getStudent( @PathVariable("id") long id){
		 StudentResponse res= studentService.getStudent(id);
		 return ResponseEntity.ok(res);
	}
	
//	fetching all the students as a list
	@GetMapping("students-bulk")
	public ResponseEntity<List<StudentResponse>> getAllStudents() {
		return      ResponseEntity.ok(studentService.getAllStudents());
	}
	
//	updating a student data by providing the id
	@PutMapping("update/{id}")
	public ResponseEntity<StudentResponse> updateStudent( @PathVariable("id") long id, @Valid @RequestBody StudentUpdateRequest req) {
			
		               return ResponseEntity.ok( studentService.update(id , req))  ;
	}
	
	
//	deleting a student by id
	@DeleteMapping("delete/{id}")
	public String deleteStudent( @PathVariable("id") long id){
		         studentService.deleteStudent(id);
		         return "Student is deleted succesfully";
	}
	
//	 deleting all the students
	@DeleteMapping("delete")
	public String deleteAll()
	{
	        	studentService.deleteAll();
		       return "Student data deleted succesfully";
	}
}
