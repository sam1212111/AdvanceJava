package com.crm.entity;

import jakarta.persistence.*;

@Entity
@Table
public class SupportTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String issueDescription;
	private Order order;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	

	
}
