package com.dnb.jdbcdemo.payload.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

	@NotBlank(message = "customer name should not be blank")
	private String customerName;
	@Length(min = 10,max=10)
	@NotBlank(message = "Contact number should not be empty")
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String customerContactNumber;
	@NotBlank(message = "Address should not be empty")
	private String customerAddress;
	@NotBlank(message = "PAN details should not be empty")
	@jakarta.validation.constraints.Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}$")
	private String customerPAN;
	@NotBlank(message = "Contact number should not be empty")
	@jakarta.validation.constraints.Pattern(regexp="^[0-9]{12}$")
	private String customerUUID;
}
