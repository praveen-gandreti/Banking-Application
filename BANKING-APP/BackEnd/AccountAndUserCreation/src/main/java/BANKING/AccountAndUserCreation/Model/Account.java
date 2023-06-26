package BANKING.AccountAndUserCreation.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Account {
	@Id
	@GeneratedValue
	private long account;
	@Pattern(regexp="^[a-zA-Z]+$",message="Enter Valid Firstname")
	private String firstName;
	private long balance=0;
	@Pattern(regexp="^[a-zA-Z]+$",message="Enter Valid Lastname")
	private String lastName;
	@Pattern(regexp="^[a-zA-Z0-9/-]+$",message="Enter Valid Address")
	private String address;
	@Pattern(regexp="^[0-9]+$",message="Enter Valid Aadhar number")
	@Column(unique=true)
	private String aadhar;
	@Pattern(regexp="^[0-9]{10}$",message="Enter Valid Modile Number")
	private String phone;
	@Column(unique=true)
	private String pan;
	@Pattern(regexp="^[a-zA-Z0-9]+@[a-z]+[/.]+[a-z]{2,}$",message="Enter Valid email")
	@Column(unique=true)
	private String email;
	private boolean online=false;
	
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
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
	
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public Account() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Account(@Pattern(regexp = "^[a-zA-Z]+$", message = "Enter Valid Firstname") String firstName, long balance,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "Enter Valid Lastname") String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9/-]+$", message = "Enter Valid Address") String address,
			@Pattern(regexp = "^[0-9]+$", message = "Enter Valid Aadhar number") String aadhar,
			@Pattern(regexp = "^[0-9]{10}$", message = "Enter Valid Modile Number") String phone, String pan,
			@Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+[/.]+[a-z]{2,}$", message = "Enter Valid email") String email,
			boolean online) {
		super();
		this.firstName = firstName;
		this.balance = balance;
		this.lastName = lastName;
		this.address = address;
		this.aadhar = aadhar;
		this.phone = phone;
		this.pan = pan;
		this.email = email;
		this.online = online;
	}
	@Override
	public String toString() {
		return "Account [account=" + account + ", firstName=" + firstName + ", balance=" + balance + ", lastName="
				+ lastName + ", address=" + address + ", aadhar=" + aadhar + ", phone=" + phone + ", pan=" + pan
				+ ", email=" + email + ", online=" + online + "]";
	}
	
	
}
