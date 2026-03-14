package com.cg.entities;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cId;
	private String  cName;
	
	@ManyToMany(mappedBy = "courses")
	private List<Students> students;


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public List<Students> getStudents() {
		return students;
	}


	public void setStudents(List<Students> students) {
		this.students = students;
	}
	
	
	
}
