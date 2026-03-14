package in.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.cg.beans.Student;
import in.cg.resources.SpringJavaConfigFile;

public class Main {
	
	public static void main(String[] args) {
		    ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfigFile.class);
		    
		    Student s1 = (Student) context.getBean("student");
		    s1.display();
		    
		
		
	}

}
