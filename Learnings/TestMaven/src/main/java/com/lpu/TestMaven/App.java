package com.lpu.TestMaven;


import java.awt.desktop.UserSessionEvent;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cg.entities.User;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User u1 = new User();
        u1.setId(1L);
        u1.setName("Sam");
        u1.setEmail("Sam@Gmail.com");
        u1.setGender("Male");
        u1.setCity("Bangalore");
        
        
        Configuration cfg = new Configuration();
        cfg.configure("/com/cg/config/hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        
        
        
        //INSERT TABLE DATA 
//        try {
//        	s.persist(u1);
//        	tr.commit();
//        	System.out.println("User added Successfully");
//        	
//        }catch(Exception e) {
//        	tr.rollback();
//        	e.printStackTrace();
//        	System.out.println("User Not Added");
//        }
        
        
        
        
        
        //GET TABLE DATA SELECT OPERATION
        
//        try {
//        	User u = s.get(User.class,1L);
//        	
//        	if(u!=null) {
//        	System.out.println(u1.getId());
//        	System.out.println(u1.getName());
//        	System.out.println(u1.getGender());
//        	System.out.println(u1.getEmail());
//        	System.out.println(u1.getCity());
//        	}else {
//        		System.out.println("User Not Found");
//        	}
//        }catch (Exception e) {
//			e.printStackTrace();
//		}
        
        
        //UPDATE OPERATION
        
User u2 = s.get(User.class, 1L);
u2.setCity("Hyderabad");

try {
	s.saveOrUpdate(u2);
	tr.commit();
	System.out.println("User updated Successfully");
	
}catch (Exception e) {
	tr.rollback();
	e.printStackTrace();
	System.out.println("User Not updated due to error");
}
    

//retrive all data select *
List<User> list = s.createQuery("from User", User.class).list();

for(User u : list){
    System.out.println(u.getId());
    System.out.println(u.getName());
    System.out.println(u.getGender());
    System.out.println(u.getEmail());
    System.out.println(u.getCity());
}


try {
    tr = s.beginTransaction();

    User u3 = s.get(User.class, 1L);

    if(u3 != null){
        s.remove(u3);
        System.out.println("User Deleted Successfully");
    } else {
        System.out.println("User not found");
    }

    tr.commit();
}
catch (Exception e){
    tr.rollback();
    e.printStackTrace();
}

        
        
    }
}
 