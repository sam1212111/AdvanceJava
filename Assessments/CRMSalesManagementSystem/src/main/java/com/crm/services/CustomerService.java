package com.crm.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.crm.config.HibernateUtil;
import com.crm.entity.Address;
import com.crm.entity.Customer;

public class CustomerService {

    public void registerCustomer(String name, String email, String phone) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = new Customer(name, email, phone);
            session.persist(customer);
            tx.commit();
            System.out.println("Customer registered: " + customer.getDetails());
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void addAddressToCustomer(Long customerId, Address address) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);
            if (customer == null) {
                System.out.println("Customer not found");
                return;
            }

            customer.setAddress(address);
            tx.commit();
            System.out.println("Address added");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void updateCustomer(Long customerId, String name, String email, String phone) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);
            if (customer == null) {
                System.out.println("Customer not found");
                return;
            }

            if (name != null) customer.setName(name);
            if (email != null) customer.setEmail(email);
            if (phone != null) customer.setPhone(phone);

            tx.commit();
            System.out.println("Customer updated");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void deleteCustomer(Long customerId) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                session.remove(customer);
            }
            tx.commit();
            System.out.println("Customer deleted");
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}