package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Student;

@Configuration
public class SpringJavaConfigFile {

	@Bean
	public Student Stdid() {
	Student s1 = new Student();
	s1.setsId(1001);
	s1.setsName("Arman");
	s1.setEmail("arman123@gmail.com");
	return s1;
}
	
	@Bean("StdObj2")
	public Student createStudentObject() {
		Student s1 = new Student();
		s1.setsId(1001);
		s1.setsName("Saurabh");
		s1.setEmail("saurabh123@gmail.com");
		return s1;
	}
	
	
	
}
