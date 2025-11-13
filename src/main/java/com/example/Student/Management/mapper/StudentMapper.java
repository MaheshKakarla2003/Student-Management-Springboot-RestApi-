package com.example.Student.Management.mapper;

import com.example.Student.Management.dto.StudentCreateRequest;
import com.example.Student.Management.dto.StudentResponse;
import com.example.Student.Management.dto.StudentUpdateRequest;
import com.example.Student.Management.entity.Student;

public class StudentMapper {

	public static Student toEntity(StudentCreateRequest req) {
		Student st = new Student();
		   st.setFirstName(req.getFirstName());
	        st.setLastName(req.getLastName());
	        st.setEmail(req.getEmail());
	        st.setPhone(req.getPhone());
	        st.setDob(req.getDob());
	        st.setBranch(req.getBranch());
	        st.setYear(req.getYear());
		return st;	
	}
	
	
	public static void updateEntity(StudentUpdateRequest req) {
		
		Student st = new Student();
		   st.setFirstName(req.getFirstName());
	        st.setLastName(req.getLastName());
	        st.setEmail(req.getEmail());
	        st.setPhone(req.getPhone());
	        st.setDob(req.getDob());
	        st.setBranch(req.getBranch());
	        st.setYear(req.getYear());
	}
	
	public static StudentResponse entityToResponse(Student s)
	{
	    if(s == null)
	    	return null;
        StudentResponse r = new StudentResponse();
        r.setId(s.getId());
        r.setFirstName(s.getFirstName());
        r.setLastName(s.getLastName());
        r.setEmail(s.getEmail());
        r.setPhone(s.getPhone());
        r.setDob(s.getDob());
        r.setBranch(s.getBranch());
        r.setYear(s.getYear());
        
        return r;
	}
}
