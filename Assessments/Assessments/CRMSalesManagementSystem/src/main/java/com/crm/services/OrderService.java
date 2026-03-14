package com.crm.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.crm.config.HibernateUtil;
import com.crm.entity.Customer;
import com.crm.entity.Order;

public class OrderService {

    public void placeOrder(Long customerId, double totalAmount) {

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);
            if (customer == null) {
                System.out.println("Customer not found with id: " + customerId);
                return;
            }

            Order order = new Order();
            order.setTotalAmount(totalAmount);

            customer.addOrder(order);

            session.persist(order);
            tx.commit();

            System.out.println("Order placed successfully");
            System.out.println("Total Amount: ₹" + totalAmount);

        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}