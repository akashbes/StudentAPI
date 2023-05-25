package com.validate.vaildatestudent.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate dateOfBirth;
	private String section;
	private String gender;
	private int marks1;
	private int marks2;
	private int marks3;
	private int total;
	private double Average;
	private String Result;
	
	public Student() {
		
	}
	
	
	public Student(String firstName, String lastName, LocalDate dateOfBirth, String section, String gender,
			int marks1, int marks2, int marks3, int total, double averageMarks, String result) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.section = section;
		this.gender = gender;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.total = total;
		Average = averageMarks;
		Result = result;
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getMarks1() {
		return marks1;
	}


	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}


	public int getMarks2() {
		return marks2;
	}


	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}


	public int getMarks3() {
		return marks3;
	}


	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public double getAverage() {
		return Average;
	}


	public void setAverage(double averageMarks) {
		Average = averageMarks;
	}


	public String getResult() {
		return Result;
	}


	public void setResult(String result) {
		Result = result;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", section=" + section + ", gender=" + gender + ", marks1=" + marks1 + ", marks2="
				+ marks2 + ", marks3=" + marks3 + ", total=" + total + ", Average=" + Average + ", Result=" + Result
				+ "]";
	}	


}
