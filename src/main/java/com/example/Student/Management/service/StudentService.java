package com.example.Student.Management.service;

import java.util.List;

import com.example.Student.Management.dto.StudentCreateRequest;
import com.example.Student.Management.dto.StudentResponse;
import com.example.Student.Management.dto.StudentUpdateRequest;

import jakarta.validation.Valid;

public interface StudentService {

	StudentResponse create(@Valid StudentCreateRequest req);

	StudentResponse getStudent( long id);

	StudentResponse update( long id, StudentUpdateRequest req);

	void deleteStudent( long id);

	void addAllStudents(@Valid List<StudentCreateRequest> list);

	List<StudentResponse> getAllStudents();

	void deleteAll();

}
