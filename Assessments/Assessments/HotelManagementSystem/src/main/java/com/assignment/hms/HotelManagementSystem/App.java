package com.assignment.hms.HotelManagementSystem;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        HibernateUtil util = new HibernateUtil();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1 Add Booking");
            System.out.println("2 View All Bookings");
            System.out.println("3 View Booking By ID");
            System.out.println("4 Update Booking");
            System.out.println("5 Delete Booking");
            System.out.println("6 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                util.addBooking();
            }
            else if (choice == 2) {
                util.viewAllBookings();
            }
            else if (choice == 3) {
                System.out.print("Enter Booking ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                util.viewBookingById(id);
            }
            else if (choice == 4) {
                System.out.print("Enter Booking ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                util.updateBooking(id);
            }
            else if (choice == 5) {
                System.out.print("Enter Booking ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                util.deleteBooking(id);
            }
            else if (choice == 6) {
                System.out.println("Exiting Application");
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}
