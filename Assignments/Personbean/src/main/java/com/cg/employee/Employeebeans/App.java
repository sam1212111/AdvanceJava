package com.cg.employee.Employeebeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Address;
import in.cg.beans.Person;
import in.cg.resources.SpringJavaConfigFile;


public class App 
{
    public static void main( String[] args )
    {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
		
		
		Person p1 = (Person) context.getBean(Person.class);
		p1.display();
		
		Address a1 = (Address) context.getBean(Address.class);
		a1.display();
 
		    
    }
}
