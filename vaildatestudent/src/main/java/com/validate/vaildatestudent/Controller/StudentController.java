package com.validate.vaildatestudent.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.validate.vaildatestudent.entity.Student;
import com.validate.vaildatestudent.entity.StudentRequest;
import com.validate.vaildatestudent.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

    @PostMapping("/createstudent")
    public ResponseEntity<Object> addStudent(@RequestBody StudentRequest request) {
    	
        // Validate input
    	ArrayList<String>  validationResult = studentService.validateStudentRequest(request);
    	
        if (validationResult.size()!=0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResult);
        }

        Student student = studentService.createStudent(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    
    @PutMapping("/updatetudent/{id}")
    public ResponseEntity<Object> updatingStudent(@RequestBody StudentRequest request, @PathVariable Long id) {
    	
    	ArrayList<String>  validationResult = studentService.validateStudentMarks(request);
    	
        if (validationResult.size()!=0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResult);
        }

        Student student = studentService.updateStudent(request, id);
        
        if(student==null) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id is Not available");
        }

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

   
}
