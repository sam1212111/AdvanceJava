package com.assignment.hms.HotelManagementSystem;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hms.entities.Booking;

public class HibernateUtil {

    Session session;
    Scanner sc;

    public HibernateUtil() {
        Configuration cfg = new Configuration();
        cfg.configure("com/hibernate/config/hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        session = sf.openSession();
        sc = new Scanner(System.in);
    }

    public void addBooking() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Type (STANDARD / DELUXE / SUITE): ");
        Booking.RoomType roomType =
                Booking.RoomType.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Enter Check-In Day: ");
        String in = sc.nextLine();

        System.out.print("Enter Check-Out Day: ");
        String out = sc.nextLine();

        Booking b = new Booking(name, roomType, in, out);

        Transaction tx = session.beginTransaction();
        try {
            session.persist(b);
            tx.commit();
            System.out.println("Booking Added Successfully");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    public void viewAllBookings() {
        List<Booking> list =
                session.createQuery("from Booking", Booking.class).list();

        for (Booking b : list) {
            System.out.println(
                    b.getBookingId() + " " +
                    b.getCustomerName() + " " +
                    b.getRoomType() + " " +
                    b.getTotalAmount()
            );
        }
    }

    public void viewBookingById(int id) {
        Booking b = session.get(Booking.class, id);
        if (b == null) {
            System.out.println("No booking found for ID: " + id);
            return;
        }

        System.out.println("Booking ID: " + b.getBookingId());
        System.out.println("Customer Name: " + b.getCustomerName());
        System.out.println("Room Type: " + b.getRoomType());
        System.out.println("Total Amount: " + b.getTotalAmount());
    }

    public void updateBooking(int id) {

        Booking b = session.get(Booking.class, id);
        if (b == null) {
            System.out.println("No booking found for ID: " + id);
            return;
        }

        while (true) {

            System.out.println("---- Update Menu ----");
            System.out.println("1 Update Customer Name");
            System.out.println("2 Update Room Type");
            System.out.println("3 Update Check-In Date");
            System.out.println("4 Update Check-Out Date");
            System.out.println("5 Exit Update Menu");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter new Customer Name: ");
                b.setCustomerName(sc.nextLine());
            }
            else if (choice == 2) {
                System.out.print("Enter new Room Type (STANDARD / DELUXE / SUITE): ");
                Booking.RoomType roomType =
                        Booking.RoomType.valueOf(sc.nextLine().toUpperCase());
                b.setRoomType(roomType);
            }
            else if (choice == 3) {
                System.out.print("Enter new Check-In Day: ");
                b.setCheckInDate(sc.nextLine());
            }
            else if (choice == 4) {
                System.out.print("Enter new Check-Out Day: ");
                b.setCheckOutDate(sc.nextLine());
            }
            else if (choice == 5) {
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }
        }

        Transaction tx = session.beginTransaction();
        try {
            session.merge(b);
            tx.commit();
            System.out.println("Booking Updated Successfully");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        }
    }


    public void deleteBooking(int id) {
        Booking b = session.get(Booking.class, id);
        if (b == null) {
            System.out.println("No booking found for ID: " + id);
            return;
        }

        Transaction tx = session.beginTransaction();
        try {
            session.remove(b);
            tx.commit();
            System.out.println("Booking Deleted Successfully");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        }
    }
}
