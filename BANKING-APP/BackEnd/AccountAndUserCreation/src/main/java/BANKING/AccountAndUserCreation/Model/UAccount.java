package BANKING.AccountAndUserCreation.Model;

public class UAccount {
	
	private String firstName;
	private String lastName;
	private String aadhar;
	private String phone;
	private String pan;
	private String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UAccount(String firstName, String lastName, String aadhar, String phone, String pan, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.aadhar = aadhar;
		this.phone = phone;
		this.pan = pan;
		this.email = email;
	}
	public UAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
