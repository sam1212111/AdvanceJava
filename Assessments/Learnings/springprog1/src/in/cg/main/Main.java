package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Address;
import in.cg.beans.Student;

public class Main {

	public static void main(String[] args) {
		  String config_loc = "in/cg/resources/applicationContext.xml";
		    ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);

		    
		    Student std1 = (Student) context.getBean("StdId");
		    std1.display();
		    
		    Student std2 = (Student) context.getBean("StdId1");
		    std2.display();
		    
		    
		    Address a1 = (Address) context.getBean("Adt1");
		    a1.display();
	}	

}
