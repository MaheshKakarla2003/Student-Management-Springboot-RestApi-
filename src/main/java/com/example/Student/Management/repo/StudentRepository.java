 package com.example.Student.Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.Management.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

//	custom fetching / searching method or query
	boolean existsByEmail(String email);

}
