package s23.BookstoreDatabase.service;

public class UserRegistration {

	private String username = "";

	private String password = "";

	private String passwordCheck = "";

	private String role = "USER";

	public UserRegistration() {
		super();
		
	}

	public UserRegistration (String username, String password, 
			String passwordCheck, String role) {
		super();
		this.username = username;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.role = role;
	}

	public UserRegistration (String username, String password, String passwordCheck) {
		super();
		this.username = username;
		this.password = password;
		this.passwordCheck = passwordCheck;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRegistration [username=" + username + ", password=" + password + ", passwordCheck=" + passwordCheck
				+ ", role=" + role + "]";
	}

}
