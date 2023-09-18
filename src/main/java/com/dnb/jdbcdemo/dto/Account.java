package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.utils.CustomAccountIdGenerator;
import com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity

public class Account {
//	public Account( String accountHolderName, String accountType, float balance, String contactNumber,
//			String address, LocalDate accountCreatedDate, LocalDate dob,  int customerId)
//			throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException,
//			InvalidBalanceException, InvalidContactNumberException, InvalidAddressException,
//			InvalidAccountStatusException {
//		super();
//		//this.setAccountId();
//		this.setAccountHolderName(accountHolderName);
//		this.setAccountType(accountType);
//		this.setBalance(balance);
//		this.setContactNumber(contactNumber);
//		this.setAddress(address);
//		this.setAccountCreatedDate(accountCreatedDate);
//		this.setDob(dob);
//		this.setCustomer(customerId);
//	}

	@Id
	//@GeneratedValue(strategy = GenerationType.UUID)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.DatePrefixedSequenceIdGenerator",
	parameters =  {@Parameter(name=DatePrefixedSequenceIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=DatePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")}
//			@Parameter(name=CustomAccountIdGenerator.VALUE_PREFIX_PARAMETER,value="A_")}
			)
	private String accountId;
	@Column(nullable = false)
	@NotBlank(message = "account holder name should not be blank")
	private String accountHolderName;
	
	private String accountType;
	@Min(value = 0,message="value should not be negative")
	private float balance;
	@Length(min = 10,max=10)
	@NotBlank(message = "Contact number should not be empty")
	@jakarta.validation.constraints.Pattern(regexp = "^[0-9]{10}$")
	private String contactNumber;
	@NotBlank(message = "Address should not be empty")
	private String address;
	private LocalDate accountCreatedDate = LocalDate.now();
	@NotNull(message = "Date should not be null")
//	@jakarta.validation.constraints.Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
	private LocalDate dob;
	@Transient
	private boolean accountStatus;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id",referencedColumnName="customerId")
	private Customer customer;

//	public void setAccountId(String accountId) throws InvalidAccountIdException {
//		String regex = "^[A-Za-z]{2}[0-9]{3}$";
//		if (Pattern.compile(regex).matcher(accountId).find())
//			this.accountId = accountId;
//		else
//			throw new InvalidAccountIdException("AccountID is not valid");
//	}
//
//	public void setAccountHolderName(String accountHolderName) throws InvalidNameException {
//		// regex to confirm length should be minimum 2 chars, and should only include
//		// characters no numbers
//		String regex = "^[a-zA-Z]{2,}$";
//		if (Pattern.compile(regex).matcher(accountHolderName).find())
//			this.accountHolderName = accountHolderName;
//		else
//			throw new InvalidNameException("Name is not valid");
//	}
//
//	public void setAccountType(String accountType) throws InvalidAccountTypeException {
//		String regex = "^(Current|Savings|Salary|Fixed)$";
//		if (Pattern.compile(regex).matcher(accountType).find())
//			this.accountType = accountType;
//		else
//			throw new InvalidAccountTypeException("Account Type is not valid");
//	}
//
//	public void setBalance(float balance) throws InvalidBalanceException {
//		String regex = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";
//		if (Pattern.compile(regex).matcher(Float.toString(balance)).find())
//			this.balance = balance;
//		else
//			throw new InvalidBalanceException("Balance value is not valid");
//	}
//
//	public void setContactNumber(String contactNumber) throws InvalidContactNumberException {
//		String regex = "^[0-9]{10}$";
//		if (Pattern.compile(regex).matcher(contactNumber).find()) {
//			this.contactNumber = contactNumber;}
//		else
//			throw new InvalidContactNumberException("Contact number not valid");
//	}
//
//	public void setAddress(String address) throws InvalidAddressException {
//		String regex = "[A-Za-z]";
//		// alpha numeric address restricting spl charcters
//		if (Pattern.compile(regex).matcher(address).find())
//			this.address = address;
//		else
//			throw new InvalidAddressException("Address is invalis shouldnt contain spl characters");
//	}
//
//	public void setAccountCreatedDate(LocalDate accountCreatedDate) throws InvalidDateException {
//		String regex = "^\\d{4}/\\d{2}/\\d{2}$";
//		String date = accountCreatedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//		if (Pattern.compile(regex).matcher(date).find())
//			this.accountCreatedDate = accountCreatedDate;
//		else
//			throw new InvalidDateException("Date is not valid");
//
//	}
//
//	public void setDob(LocalDate dob) throws InvalidDateException {
//		String regex = "^\\d{4}/\\d{2}/\\d{2}$";
//		String date = dob.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//		if (Pattern.compile(regex).matcher(date).find())
//			this.dob = dob;
//		else
//			throw new InvalidDateException("Date is not valid");
//	}
//
//	public void setAccountStatus(boolean accountStatus) throws InvalidAccountStatusException {
//		String regex = "^(true|false)$";
//		String str = Boolean.toString(accountStatus);
//		if (Pattern.compile(regex).matcher(str).find())
//			this.accountStatus = accountStatus;
//		else
//			throw new InvalidAccountStatusException("Account Status is invalid");
//	}
//
//	public void setCustomer(int customerId) {
//		this.customerId = customerId;
//	}

}
