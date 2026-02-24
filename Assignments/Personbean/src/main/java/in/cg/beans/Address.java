package in.cg.beans;



public class Address {

	private String city;
	private int pincode;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	public void display() {
		System.out.println(city+ " "+pincode);
	}
}
