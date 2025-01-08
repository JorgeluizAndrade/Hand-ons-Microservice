package com.microsservice.user.services;

import org.springframework.stereotype.Service;

import com.microsservice.user.entity.User;
import com.microsservice.user.producers.UserProducer;
import com.microsservice.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final UserProducer userProducer;

	public UserService(UserRepository userRepository, UserProducer userProducer) {
		this.userRepository = userRepository;
		this.userProducer = userProducer;
	}

	
	@Transactional
	public User save(User user) {
		user = userRepository.save(user);

		userProducer.publishMessageEmail(user);

		return user;
	}
}
