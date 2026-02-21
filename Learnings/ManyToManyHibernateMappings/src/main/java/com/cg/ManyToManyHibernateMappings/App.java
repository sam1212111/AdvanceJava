package com.cg.ManyToManyHibernateMappings;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cg.entities.Courses;
import com.cg.entities.Students;

public class App {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("/com/cg/config/hibernate.cfg.xml");
        cfg.addAnnotatedClass(Students.class);
        cfg.addAnnotatedClass(Courses.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Courses c1 = new Courses();
        c1.setcName("Java");

        Courses c2 = new Courses();
        c2.setcName("Hibernate");

        Students s1 = new Students();
        s1.setsName("Sam");
        s1.setCourses(Arrays.asList(c1, c2));

        Students s2 = new Students();
        s2.setsName("John");
        s2.setCourses(Arrays.asList(c1));

        c1.setStudents(Arrays.asList(s1, s2));
        c2.setStudents(Arrays.asList(s1));

        session.persist(s1);
        session.persist(s2);

        tx.commit();

        session.close();
        factory.close();
    }
}