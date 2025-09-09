package com.hehe.studi_kasus_bean_validation.model;

public class User {

	private Long id;
	private String username;
	private String email;
	private String password;
	private Integer age;
	private Address address;

	public User() {
	}



	public User(Long id, String username, String email, String password, Integer age, Address address) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
