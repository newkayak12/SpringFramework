package com.mvcboot.springboot.model.vo;




public class Member {

	private String userId, password, userName, gender ;
	private int age;
	private String email, phone, address;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String userId, String password, String userName, String gender, int age, String email, String phone,
			String address) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", userName=" + userName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
