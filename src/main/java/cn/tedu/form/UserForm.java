package cn.tedu.form;

import java.io.Serializable;

public class UserForm implements Serializable {
	private String username;
	private String password;
	private int age;
	private String phone;
	private String email;
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserForm [username=" + username + ", password=" + password + ", age=" + age + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
}
