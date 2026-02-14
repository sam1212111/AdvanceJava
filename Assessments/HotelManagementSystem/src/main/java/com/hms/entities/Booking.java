package com.hms.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Booking {

    public enum RoomType {
        STANDARD(2000),
        DELUXE(3500),
        SUITE(5000);

        private final int pricePerDay;

        RoomType(int pricePerDay) {
            this.pricePerDay = pricePerDay;
        }

        public int getPricePerDay() {
            return pricePerDay;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    public Booking() {}

    public Booking(String customerName, RoomType roomType, String checkInDate, String checkOutDate) {
        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateAmount();
    }

    private double calculateAmount() {
        int days = Integer.parseInt(checkOutDate) - Integer.parseInt(checkInDate);
        return days * roomType.getPricePerDay();
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
        this.totalAmount = calculateAmount();
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
        this.totalAmount = calculateAmount();
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
