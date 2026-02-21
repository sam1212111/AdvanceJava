package com.crm.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("/com/crm/config/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void close() {
        sessionFactory.close();
    }
}