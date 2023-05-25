package com.validate.vaildatestudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validate.vaildatestudent.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	

}
