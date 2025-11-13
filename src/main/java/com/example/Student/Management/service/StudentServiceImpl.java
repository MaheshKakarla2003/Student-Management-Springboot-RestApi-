package com.example.Student.Management.service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Student.Management.dto.StudentCreateRequest;
import com.example.Student.Management.dto.StudentResponse;
import com.example.Student.Management.dto.StudentUpdateRequest;
import com.example.Student.Management.entity.Student;
import com.example.Student.Management.exceptions.NotFoundException;
import com.example.Student.Management.mapper.StudentMapper;
import com.example.Student.Management.repo.StudentRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class StudentServiceImpl  implements StudentService{


	private final StudentRepository repo;
	
	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}
	@Override
	public StudentResponse create(@Valid StudentCreateRequest req) {
	  
		     if(repo.existsByEmail(req.getEmail()))
		    	  throw new DataIntegrityViolationException("this email id is already exist");
		
	          return   StudentMapper.entityToResponse( repo.save( StudentMapper.toEntity(req)));
	
	}
	@Override
	public StudentResponse getStudent( long id) {
                        Student st= repo.findById(id).orElseThrow(()->  new NotFoundException("student id does not exist"));
                  return    StudentMapper.entityToResponse(st);
	}
	@Override
	public StudentResponse update( long id, StudentUpdateRequest req) {
		 Student st= repo.findById(id).orElseThrow(()->  new NotFoundException("student id does not exist"));
//		 we already provided validations so here no need to check for null and empty values ,
//		 we did not provide for DOB so now here providing check point
			    st.setLastName(req.getLastName());
		       st.setFirstName(req.getFirstName());
		       st.setEmail(req.getEmail());
		       st.setPhone(req.getPhone());
		 if(Objects.nonNull(req.getBranch()) && !"".equalsIgnoreCase(req.getBranch()))
		       st.setBranch(req.getBranch());
		       st.setDob(req.getDob());
		       st.setYear(req.getYear());
		       
		return StudentMapper.entityToResponse(repo.save(st));
	}
	@Override
	public void deleteStudent( long id) {
	            Student st = repo.findById(id).orElseThrow(()-> new NotFoundException("student id does not exist"));
	             repo.delete(st);            
	}
	@Override
	public void addAllStudents(@Valid  List<StudentCreateRequest> list)
	{	
		        boolean flag=false;
                for(int i=0;i<list.size();i++)
                 { 
                	StudentCreateRequest temp=list.get(i);
                	if(repo.existsByEmail(temp.getEmail()))
                	{   flag=true;
                		continue;
                	}              		 
                	else
                		repo.save( StudentMapper.toEntity(temp));         		
                }
                if(flag)
                throw new DataIntegrityViolationException("one or more email id's  in your list are already exist");
	}
	@Override
	public List<StudentResponse> getAllStudents() {
		
		            List<Student> stList=  repo.findAll();
		            List<StudentResponse> srList= stList.stream()
		            		.map(StudentMapper::entityToResponse)
                            .collect(Collectors.toList());
		            		 return srList;                                       
	}
	@Override
	public void deleteAll() {
	
		 repo.deleteAll();
	}

}
