package com.hehe.studi_kasus_bean_validation.service.impl;

import com.hehe.studi_kasus_bean_validation.dto.UserRegistrationRequest;
import com.hehe.studi_kasus_bean_validation.model.Address;
import com.hehe.studi_kasus_bean_validation.model.User;
import com.hehe.studi_kasus_bean_validation.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private List< User> users;

	public RegistrationServiceImpl() {
		this.users = new ArrayList<>();
	}

	@Override
	public User registerUser(UserRegistrationRequest userRegistrationRequest) {
		User user = new User();
		user.setId(generatedId());
		user.setUsername(userRegistrationRequest.getUsername());
		user.setPassword(userRegistrationRequest.getPassword());
		user.setEmail(userRegistrationRequest.getEmail());

		Address address = new Address();
		address.setCity(userRegistrationRequest.getAddress().getCity());
		address.setCountry(userRegistrationRequest.getAddress().getCountry());
		address.setStreet(userRegistrationRequest.getAddress().getStreet());
		address.setPostalCode(userRegistrationRequest.getAddress().getPostalCode());

		user.setAddress(address);

		this.users.add(user);
		return user;
	}

	private long generatedId() {
		if (users.size() <= 0) {
			return 1;
		} else {
			return users.getLast().getId() + 1;
		}
	}

}
