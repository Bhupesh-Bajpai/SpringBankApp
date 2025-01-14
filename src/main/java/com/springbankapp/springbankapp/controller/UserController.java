package com.springbankapp.springbankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbankapp.springbankapp.dto.BankResponse;
import com.springbankapp.springbankapp.dto.UserRequest;
import com.springbankapp.springbankapp.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public BankResponse createAccount(@RequestBody UserRequest userRequest) {
		return userService.createAccount(userRequest);
	}
}
