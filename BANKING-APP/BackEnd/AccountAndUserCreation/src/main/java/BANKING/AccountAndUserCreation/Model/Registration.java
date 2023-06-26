package BANKING.AccountAndUserCreation.Model;

public class Registration {
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String aadhar;
	private String phone;
	private String pan;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(Long id, String firstName, String lastName, String address, String aadhar, String phone,
			String pan, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.aadhar = aadhar;
		this.phone = phone;
		this.pan = pan;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", aadhar=" + aadhar + ", phone=" + phone + ", pan=" + pan + ", email=" + email + "]";
	}
	

}
