package com.microsservice.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microsservice.user.dto.UserDTO;
import com.microsservice.user.entity.User;
import com.microsservice.user.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userRecordDto) {
		var user = new User();
		BeanUtils.copyProperties(userRecordDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

}
