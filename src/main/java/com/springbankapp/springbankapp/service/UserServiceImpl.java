package com.springbankapp.springbankapp.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbankapp.springbankapp.dto.AccountInfo;
import com.springbankapp.springbankapp.dto.BankResponse;
import com.springbankapp.springbankapp.dto.UserRequest;
import com.springbankapp.springbankapp.entity.User;
import com.springbankapp.springbankapp.repository.UserRepository;
import com.springbankapp.springbankapp.utills.AccountUtils;
import lombok.Builder;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public BankResponse createAccount(UserRequest userRequest) {

		if (userRepository.existsByEmail(userRequest.getEmail())){
			return BankResponse.builder()
					.responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
					.responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
					.accountInfo(null)
					.build();
		}
//		creating a new user by this user request and save one user inside database in users table.
		   User newUser = User.builder()
	                .firstName(userRequest.getFirstName())
	                .lastName(userRequest.getLastName())
	                .otherName(userRequest.getOtherName())
	                .gender(userRequest.getGender())
	                .address(userRequest.getAddress())
	                .stateOfOrigin(userRequest.getStateOfOrigin())
	                .accountNumber(AccountUtils.genrateAccountNumber())
	                .accountBalance(BigDecimal.ZERO)
	                .email(userRequest.getEmail())
	                .phoneNumber(userRequest.getPhoneNumber())
	                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
	                .status("ACTIVE")
	                .build();
	                
	       User savedUser = userRepository.save(newUser);
	                
	                return BankResponse.builder()
	                        .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
	                        .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
	                        .accountInfo(AccountInfo.builder()
	                                .accountBalance(savedUser.getAccountBalance())
	                                .accountNumber(savedUser.getAccountNumber())
	                                .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
	                                .build())
	                        .build();
	}



}
