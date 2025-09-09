package com.hehe.studi_kasus_bean_validation.dto;

import com.hehe.studi_kasus_bean_validation.validation.annotation.PasswordMatches;
import com.hehe.studi_kasus_bean_validation.validation.annotation.StrongPassword;
import com.hehe.studi_kasus_bean_validation.validation.group.AdvancedGroup;
import com.hehe.studi_kasus_bean_validation.validation.group.BasicGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@PasswordMatches(groups = {BasicGroup.class})
public class UserRegistrationRequest {

	@NotBlank(message = "{user.username.notblank}", groups = {BasicGroup.class})
	@Size(min = 3, max = 20, message = "{user.username.size}", groups = BasicGroup.class)
	private String username;

	@NotBlank(message = "{user.email.notblank}", groups = {BasicGroup.class})
	@Email(message = "{user.email.invalid}", groups = {BasicGroup.class})
	private String email;

	@NotBlank(message = "{user.password.notblank}", groups = {BasicGroup.class})
	@StrongPassword(groups = AdvancedGroup.class)
	private String password;


	@NotBlank(message = "{user.confirmPassword.notblank}", groups = {BasicGroup.class})
	private String confirmPassword;

	public UserRegistrationRequest(String username, String email, String password, String confirmPassword, Integer age, AddressDto address) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.age = age;
		this.address = address;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@NotNull(message = "{user.age.notnull}", groups = {BasicGroup.class})
	@Min(value = 13, message = "{user.age.min}",  groups = {BasicGroup.class})
	private Integer age;

	@Valid
	@NotNull(message = "{user.address.notnull}", groups = {BasicGroup.class})
	private AddressDto address;

	public UserRegistrationRequest() {
	}

	public UserRegistrationRequest(String username, String email, String password, Integer age, AddressDto address) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.address = address;
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

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserRegistrationRequest{" +
				"username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", address=" + address +
				'}';
	}
}
