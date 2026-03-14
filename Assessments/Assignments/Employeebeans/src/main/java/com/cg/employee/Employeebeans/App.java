package com.cg.employee.Employeebeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.cg.beans.Employee;
import in.cg.resources.SpringJavaConfigFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
		    
		   Employee s1 = (Employee) context.getBean("employee");
		    s1.display();
		    
    }
}
