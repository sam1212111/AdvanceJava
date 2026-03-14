package in.cg.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("1001")
	private int sId;
	@Value("Arman")
	private String sName;
	@Value("arman123@gmail.com")
	private String email;
	
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public void display() {
		System.out.println(this.sId + " "+this.sName+" "+this.email);
		
	}
	
}
