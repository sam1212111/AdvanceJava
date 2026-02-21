package com.crm.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Lead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String source;
	private String contactInfo;
	private SalesEmployee salesEmployee;
	
	
	private Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public SalesEmployee getSalesEmployee() {
		return salesEmployee;
	}
	public void setSalesEmployee(SalesEmployee salesEmployee) {
		this.salesEmployee = salesEmployee;
	}

	
	
}
