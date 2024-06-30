package com.springbankapp.springbankapp.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	    private String firstName;
	    private String lastName;
	    private String otherName;
	    private String gender;
	    private String address;
	    private String stateOfOrigin;
	    private String accountNumber;
	    private BigDecimal accountBalance;
	    private String email;
	    private String phoneNumber;
	    private String alternativePhoneNumber;
	    private String status;
}
