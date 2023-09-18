package com.dnb.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;
import com.dnb.jdbcdemo.utils.CustomAccountIdGenerator;
import com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Customer {

//	public Customer(int customerId, String customerName, String customerContactNumber, String customerAddress,
//			String customerPAN, String customerUUID) throws InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
//		super();
//		this.setCustomerId(customerId);
//		this.setCustomerName(customerName);
//		this.setCustomerContactNumber(customerContactNumber);
//		this.setCustomerAddress(customerAddress);
//		this.setCustomerPAN(customerPAN);
//		this.setCustomerUUID(customerUUID);
//	}

	@Id
	@GeneratedValue
	private int customerId;
	@NotBlank(message = "customer name shouldn't be blank")
	private String customerName;
	@Length(min = 10,max=10)
	@NotBlank(message = "Contact number shouldn't be empty")
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String customerContactNumber;
	@NotBlank(message = "Address shouldn't be empty")
	private String customerAddress;
	@NotBlank(message = "PAN details shouldn't be empty")
	@jakarta.validation.constraints.Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}$")
	private String customerPAN;
	@NotBlank(message = "Contact number should not be empty")
	@jakarta.validation.constraints.Pattern(regexp="^[0-9]{12}$")
	private String customerUUID;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
	private Set<Account> accountList=new HashSet<>();

//	public void setCustomerId(int customerId) throws InvalidCustomerIdException {
//		String regex = "^-?\\d+$";
//
//		if (Pattern.compile(regex).matcher(Integer.toString(customerId)).find())
//
//			this.customerId = customerId;
//
//		else
//
//			throw new InvalidCustomerIdException("Given ID is not valid");
//	}
//
//	public void setCustomerName(String customerName) throws InvalidNameException {
//		String regex = "^[a-zA-Z]{2,}$";
//
//		if (Pattern.compile(regex).matcher(customerName).find())
//			this.customerName = customerName;
//		else
//			throw new InvalidNameException("Name is not valid");
//	}
//
//	public void setCustomerContactNumber(String customerContactNumber) throws InvalidContactNumberException {
//		String regex = "^[1-9][0-9]{0,9}$";
//		//Maximum length should be 10 and contain only numbers and should not start with 0
//		if (Pattern.compile(regex).matcher(customerContactNumber).find())
//			this.customerContactNumber = customerContactNumber;
//		else
//			throw new InvalidContactNumberException("Invalid Contact number");
//	}
//
//	public void setCustomerAddress(String customerAddress) throws InvalidAddressException {
//		String regex = "[A-Za-z]";
//		// alpha numeric address restricting spl charcters
//		if (Pattern.compile(regex).matcher(customerAddress).find())
//			this.customerAddress = customerAddress;
//		else
//			throw new InvalidAddressException("Address is invalis shouldnt contain spl characters");
//	}
//
//	public void setCustomerPAN(String customerPAN) throws InvalidGovtIdException {
//		String regex="^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
//		if (Pattern.compile(regex).matcher(customerPAN).find())
//			this.customerPAN = customerPAN;
//		else
//			throw new InvalidGovtIdException("Invalid PAN Card");
//	}
//
//	public void setCustomerUUID(String customerUUID) throws InvalidGovtIdException {
//		String regex="^[0-9]{12}$";
//		if (Pattern.compile(regex).matcher(customerUUID).find())
//			this.customerUUID = customerUUID;
//		else
//			throw new InvalidGovtIdException("Invalid Aadhaar Card");
//	}

}
