package com.validate.vaildatestudent.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validate.vaildatestudent.entity.Student;
import com.validate.vaildatestudent.entity.StudentRequest;
import com.validate.vaildatestudent.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public ArrayList<String> validateStudentRequest(StudentRequest request) {

		ArrayList<String> errorList = new ArrayList<String>();

		if (request.getFirstName().length() < 3) {
			errorList.add("First name should be at least 3 characters long.");
		}

		if (request.getLastName().length() < 3) {
			errorList.add("Last name should be at least 3 characters long.");
		}

		LocalDate currentDate = LocalDate.now();
		LocalDate dob = request.getDateOfBirth();
		int age = Period.between(dob, currentDate).getYears();
		if (age <= 15 || age > 20) {
			errorList.add("Age should be greater than 15 and less than or equal to 20 years.");
		}

		int mark1 = request.getMarks1();
		int mark2 = request.getMarks2();
		int mark3 = request.getMarks3();
		if (mark1 < 0 || mark1 > 100 || mark2 < 0 || mark2 > 100 || mark3 < 0 || mark3 > 100) {
			errorList.add("Marks should be between 0 and 100.");
		}

		if (!request.getSection().matches("[A-C]")) {
			errorList.add("Invalid section. Valid values are A, B, or C.");
		}

		if (!request.getGender().matches("[MF]")) {
			errorList.add("Invalid gender. Valid values are M or F.");
		}

		return errorList;
	}

	public Student createStudent(StudentRequest request) {

		// Calculate total and average marks
		int totalMarks = request.getMarks1() + request.getMarks2() + request.getMarks3();
		double averageMarks = totalMarks / 3.0;

		// Determine the result
		String result = (request.getMarks1() >= 35 && request.getMarks2() >= 35 && request.getMarks3() >= 35) ? "Pass"
				: "Fail";

		// Create student object
		Student student = new Student(request.getFirstName(), request.getLastName(), request.getDateOfBirth(),
				request.getSection(), request.getGender(), request.getMarks1(), request.getMarks2(),
				request.getMarks3(), totalMarks, averageMarks, result);

		// Saving in database
		studentRepo.save(student);

		return student;

	}

	public Student updateStudent(StudentRequest request, Long id) {
		Student student = null;
		try {
			student = studentRepo.findById(id).get();
		}catch(Exception e) {
			return null;
		}
		

		// Calculate total and average marks
		int totalMarks = request.getMarks1() + request.getMarks2() + request.getMarks3();
		double averageMarks = totalMarks / 3.0;

		// Determine the result
		String result = (request.getMarks1() >= 35 && request.getMarks2() >= 35 && request.getMarks3() >= 35) ? "Pass"
				: "Fail";

		student.setMarks1(request.getMarks1());
		student.setMarks2(request.getMarks2());
		student.setMarks3(request.getMarks3());
		student.setTotal(totalMarks);
		student.setResult(result);
		student.setAverage(averageMarks);

		studentRepo.save(student);

		return student;
	}

	public ArrayList<String> validateStudentMarks(StudentRequest request) {

		ArrayList<String> errorList = new ArrayList<String>();
		int mark1 = request.getMarks1();
		int mark2 = request.getMarks2();
		int mark3 = request.getMarks3();
		if (mark1 < 0 || mark1 > 100 || mark2 < 0 || mark2 > 100 || mark3 < 0 || mark3 > 100) {
			errorList.add("Marks should be between 0 and 100.");
		}
		return errorList;
	}

}
