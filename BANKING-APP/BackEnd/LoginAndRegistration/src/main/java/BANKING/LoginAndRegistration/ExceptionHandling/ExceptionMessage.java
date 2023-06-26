package BANKING.LoginAndRegistration.ExceptionHandling;

import java.util.Date;

public class ExceptionMessage {

	private Date date;
	private String message;
	private String url;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ExceptionMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionMessage(Date date, String message, String url) {
		super();
		this.date = date;
		this.message = message;
		this.url = url;
	}
	@Override
	public String toString() {
		return "ExceptionMessage [date=" + date + ", message=" + message + ", url=" + url + "]";
	}
	
}
