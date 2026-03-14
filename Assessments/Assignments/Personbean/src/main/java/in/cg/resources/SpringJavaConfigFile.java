package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Person;


@Configuration
public class SpringJavaConfigFile {
	
	@Bean
	public Person Emp1() {
		Person p1 = new Person();
		p1.setpId(12121);
		p1.setpName("Arman");
		p1.setGender("LGBTQ");
		
		return p1;
	}
	
	@Bean
	public Address Ad1() {
		Address a1 = new Address();
		a1.setCity("Jaipur");
		a1.setPincode(12321);
		
		return a1;
	}
	

}

