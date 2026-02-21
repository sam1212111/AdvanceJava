package com.crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Order() {
        this.orderDate = java.time.LocalDate.now().toString();
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}