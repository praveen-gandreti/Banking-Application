package BANKING.AccountAndUserCreation.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class UserData {
	@Id
	@GeneratedValue
	private long id;
	@Pattern(regexp="^[a-zA-Z0-9]+@[a-zA-Z]+[/.]{1}[a-zA-Z]+$")
	@Column(unique=true)
	private String userName;
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;
	private String role;
	private long account=0;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(@Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z]+[/.]{1}[a-zA-Z]+$") String userName,
			@Pattern(regexp = "^[a-zA-Z0-9]{8}$") String password, @Pattern(regexp = "a-zA-Z") String role,
			long account) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ ", account=" + account + "]";
	}
	
	
	
	

}
