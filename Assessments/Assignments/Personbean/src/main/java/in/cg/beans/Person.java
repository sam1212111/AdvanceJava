package in.cg.beans;




public class Person {
	private int pId;
	private String pName;
	private String gender;
	
	
	
	
	public int getpId() {
		return pId;
	}




	public void setpId(int pId) {
		this.pId = pId;
	}




	public String getpName() {
		return pName;
	}




	public void setpName(String pName) {
		this.pName = pName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public void display() {
		System.out.println(pId+ " "+pName+" "+gender);
		
	}
	
}
