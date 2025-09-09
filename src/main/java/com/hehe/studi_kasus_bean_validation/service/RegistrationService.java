package com.hehe.studi_kasus_bean_validation.service;

import com.hehe.studi_kasus_bean_validation.dto.UserRegistrationRequest;
import com.hehe.studi_kasus_bean_validation.model.User;

public interface RegistrationService {

	User registerUser( UserRegistrationRequest userRegistrationRequest);

}
