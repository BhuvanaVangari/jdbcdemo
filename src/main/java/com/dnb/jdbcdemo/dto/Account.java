package com.dnb.jdbcdemo.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountStatusException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity

public class Account {
	public Account( String accountHolderName, String accountType, float balance, String contactNumber,
			String address, LocalDate accountCreatedDate, LocalDate dob,  int customerId)
			throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException,
			InvalidBalanceException, InvalidContactNumberException, InvalidAddressException,
			InvalidAccountStatusException {
		super();
		//this.setAccountId();
		this.setAccountHolderName(accountHolderName);
		this.setAccountType(accountType);
		this.setBalance(balance);
		this.setContactNumber(contactNumber);
		this.setAddress(address);
		this.setAccountCreatedDate(accountCreatedDate);
		this.setDob(dob);
		this.setCustomer(customerId);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String accountId;
	@Column(nullable = false)
	private String accountHolderName;
	private String accountType;
	private float balance;
	private String contactNumber;
	private String address;
	private LocalDate accountCreatedDate = LocalDate.now();
	private LocalDate dob;
	@Transient
	private boolean accountStatus;
	private int customerId;

//	public void setAccountId(String accountId) throws InvalidAccountIdException {
//		String regex = "^[A-Za-z]{2}[0-9]{3}$";
//		if (Pattern.compile(regex).matcher(accountId).find())
//			this.accountId = accountId;
//		else
//			throw new InvalidAccountIdException("AccountID is not valid");
//	}

	public void setAccountHolderName(String accountHolderName) throws InvalidNameException {
		// regex to confirm length should be minimum 2 chars, and should only include
		// characters no numbers
		String regex = "^[a-zA-Z]{2,}$";

		if (Pattern.compile(regex).matcher(accountHolderName).find())
			this.accountHolderName = accountHolderName;
		else
			throw new InvalidNameException("Name is not valid");
	}

	public void setAccountType(String accountType) throws InvalidAccountTypeException {

		String regex = "^(Current|Savings|Salary|Fixed)$";

		if (Pattern.compile(regex).matcher(accountType).find())

			this.accountType = accountType;

		else

			throw new InvalidAccountTypeException("Account Type is not valid");

	}

	public void setBalance(float balance) throws InvalidBalanceException {

		String regex = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";

		if (Pattern.compile(regex).matcher(Float.toString(balance)).find())

			this.balance = balance;

		else

			throw new InvalidBalanceException("Balance value is not valid");

	}

	public void setContactNumber(String contactNumber) throws InvalidContactNumberException {

		String regex = "^[0-9]{10}$";

		if (Pattern.compile(regex).matcher(contactNumber).find()) {

			this.contactNumber = contactNumber;}

		else

			throw new InvalidContactNumberException("Contact number not valid");

	}

	public void setAddress(String address) throws InvalidAddressException {
		String regex = "[A-Za-z]";
		// alpha numeric address restricting spl charcters
		if (Pattern.compile(regex).matcher(address).find())
			this.address = address;
		else
			throw new InvalidAddressException("Address is invalis shouldnt contain spl characters");
	}

	public void setAccountCreatedDate(LocalDate accountCreatedDate) throws InvalidDateException {
		String regex = "^\\d{2}/\\d{2}/\\d{4}$";
		String date = accountCreatedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if (Pattern.compile(regex).matcher(date).find())
			this.accountCreatedDate = accountCreatedDate;
		else
			throw new InvalidDateException("Date is not valid");

	}

	public void setDob(LocalDate dob) throws InvalidDateException {
		String regex = "^\\d{2}/\\d{2}/\\d{4}$";
		String date = dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		if (Pattern.compile(regex).matcher(date).find())
			this.dob = dob;
		else
			throw new InvalidDateException("Date is not valid");
	}

	public void setAccountStatus(boolean accountStatus) throws InvalidAccountStatusException {
		String regex = "^(true|false)$";
		String str = Boolean.toString(accountStatus);
		if (Pattern.compile(regex).matcher(str).find())
			this.accountStatus = accountStatus;
		else
			throw new InvalidAccountStatusException("Account Status is invalid");
	}

	public void setCustomer(int customerId) {
		this.customerId = customerId;
	}

}
