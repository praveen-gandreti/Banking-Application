package BANKING.LoginAndRegistration.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Registration {
	@Id
	@GeneratedValue
	private Long id;
	@Pattern(regexp="^[a-zA-Z]+$",message="Enter Valid Firstname")
	private String firstName;
	@Pattern(regexp="^[a-zA-Z]+$",message="Enter Valid Lastname")
	private String lastName;
	@Pattern(regexp="^[a-zA-Z0-9/-]+$",message="Enter Valid Address")
	private String address;
	@Pattern(regexp="^[0-9]+$",message="Enter Valid Aadhar number")
	@Column(unique=true)
	private String aadhar;
	@Pattern(regexp="^[0-9]{10}$",message="Enter Valid Modile Number")
	private String phone;
	@Column(unique=true,nullable=true)
	private String pan;
	@Pattern(regexp="^[a-zA-Z0-9]+@[a-z]+[/.]+[a-z]{2,}$",message="Enter Valid email")
	@Column(unique=true)
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
	public Registration(@Pattern(regexp = "^[a-zA-Z]+$", message = "Enter Valid Firstname") String firstName,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "Enter Valid Lastname") String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9/-]+$", message = "Enter Valid Address") String address,
			@Pattern(regexp = "^[0-9]+$", message = "Enter Valid Aadhar number") String aadhar,
			@Pattern(regexp = "^[0-9]{10}$", message = "Enter Valid Modile Number") String phone, String pan,
			@Pattern(regexp = "^[a-zA-Z0-9]@[a-z]+[/.]+[a-z]{2,}$", message = "Enter Valid email") String email) {
		super();
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
