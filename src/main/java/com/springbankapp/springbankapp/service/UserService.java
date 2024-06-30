package com.springbankapp.springbankapp.service;

import org.springframework.stereotype.Service;

import com.springbankapp.springbankapp.dto.BankResponse;
import com.springbankapp.springbankapp.dto.UserRequest;
import com.springbankapp.springbankapp.entity.User;


@Service
public interface UserService {

	BankResponse createAccount(UserRequest userRequest);
	
}
