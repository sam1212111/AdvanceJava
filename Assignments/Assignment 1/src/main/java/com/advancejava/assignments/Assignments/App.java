package com.advancejava.assignments.Assignments;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.crud.entities.Employee;

public class App {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("/com/Assignment/config/hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        
        //INSERTING DATA INTO THE TABLE
        try {

            List<Employee> employees = Arrays.asList(

                new Employee("SI112","Sam","Male","sam@gmail.com","989834534","Software Developer",100000L),
                new Employee("SI113","James","Male","james@gmail.com","9876543210","Backend Developer",95000L),
                new Employee("SI114","Emma","Female","emma@gmail.com","9123456780","UI Designer",85000L),
                new Employee("SI115","Michael","Male","michael@gmail.com","9012345678","Tester",70000L),
                new Employee("SI116","Olivia","Female","olivia@gmail.com","9988776655","HR Manager",80000L),
                new Employee("SI117","Daniel","Male","daniel@gmail.com","8899776655","DevOps Engineer",105000L),
                new Employee("SI118","Sophia","Female","sophia@gmail.com","7766554433","Data Analyst",92000L),
                new Employee("SI119","William","Male","william@gmail.com","6655443322","System Administrator",88000L),
                new Employee("SI120","Isabella","Female","isabella@gmail.com","7788996655","Project Manager",120000L),
                new Employee("SI121","Alexander","Male","alexander@gmail.com","8899001122","Security Engineer",110000L),
                new Employee("SI122","Charlotte","Female","charlotte@gmail.com","9911223344","Business Analyst",97000L)

            );

            for(Employee emp : employees) {
                session.persist(emp);
            }

            tx.commit();
            System.out.println("Employees inserted successfully");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        	
        
        //UPDATE DATA
        
        tx = session.beginTransaction();
        try {
            Employee emp = session.get(Employee.class, "SI201");
            emp.setSalary(110000L);
            emp.setJobTitle("Senior Developer");
            session.merge(emp);
            tx.commit();
            System.out.println("UPDATE DONE");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        
        
        
        //DELETE DATA
        tx = session.beginTransaction();
        try {
            Employee emp = session.get(Employee.class, "SI202");
            session.remove(emp);
            tx.commit();
            System.out.println("DELETE DONE");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        
        
        //turncate data 
        
//        try {
//            session.createNativeQuery("TRUNCATE TABLE employee").executeUpdate();
//            tx.commit();
//            System.out.println("Table truncated successfully");
//
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//            System.out.println("Truncate failed");
//        } 
        
        
        
    }
}
