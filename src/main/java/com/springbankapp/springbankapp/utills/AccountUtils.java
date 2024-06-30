package com.springbankapp.springbankapp.utills;

import java.time.Year;

public class AccountUtils {
	
//	generateNumber for a new User.
	
	  public static final String ACCOUNT_EXISTS_CODE = "001";
	  public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account Created!";
	  public static final String ACCOUNT_CREATION_SUCCESS = "002";
	  public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created!";
	
	public static String genrateAccountNumber() {
		
		
		
		Year currYear = Year.now();
		
		int max = 999999;
		int min = 100000;
		
		int ramdomNumber = (int)Math.floor(Math.random()*(max-min+1));

		String yearNumber = String.valueOf(currYear);
		String randomNumber = String.valueOf(ramdomNumber);
		
		StringBuilder accountNumber = new StringBuilder();
		
		return accountNumber.append(yearNumber).append(randomNumber).toString();
		
		
	}
	
}
