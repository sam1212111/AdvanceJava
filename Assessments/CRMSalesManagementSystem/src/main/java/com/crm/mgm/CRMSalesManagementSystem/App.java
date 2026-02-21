package com.crm.mgm.CRMSalesManagementSystem;

import java.util.Scanner;
import com.crm.config.HibernateUtil;
import com.crm.entity.Address;
import com.crm.services.CustomerService;
import com.crm.services.OrderService;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();

        boolean running = true;

        while (running) {

            System.out.println("\n==== CRM MENU ====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Place Order");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter customer id: ");
                    Long cid = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter street: ");
                    String street = sc.nextLine();
                    System.out.print("Enter city: ");
                    String city = sc.nextLine();
                    System.out.print("Enter state: ");
                    String state = sc.nextLine();
                    System.out.print("Enter pincode: ");
                    String pincode = sc.nextLine();

                    Address address = new Address(street, city, state, pincode);
                    customerService.addAddressToCustomer(cid, address);
                    break;

                case 3:
                    System.out.print("Enter customer id: ");
                    Long customerId = sc.nextLong();
                    System.out.print("Enter total amount: ");
                    double total = sc.nextDouble();
                    orderService.placeOrder(customerId, total);
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting application");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
        HibernateUtil.close();
    }
}