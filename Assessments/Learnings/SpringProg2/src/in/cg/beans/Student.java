package in.cg.beans;

public class Student {
	private int sId;
	private String sName;
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
