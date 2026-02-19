package com.crud.entities;

import jakarta.persistence.*;


@Entity
@Table
public class Employee {
	@Column
	private String name;
	@Id
	private String id;
	@Column
	private String gender;
	@Column
	private String emailId;
	@Column
	private String phoneNo;
	@Column
	private String jobTitle;
	@Column
	private Long salary;
	
	
	public Employee(String id, String name, String gender,
            String emailId, String phoneNo,
            String jobTitle, Long salary) {

this.id = id;
this.name = name;
this.gender = gender;
this.emailId = emailId;
this.phoneNo = phoneNo;
this.jobTitle = jobTitle;
this.salary = salary;
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	
}
