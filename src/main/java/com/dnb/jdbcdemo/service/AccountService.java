package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountStatusException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;

public interface AccountService {
	public Account createAccount(Account account) throws IdNotFoundException, InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException;
	
	public Optional<Account> getAccountById(String accountId);// throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
	
	public Optional<Account> getAccountByContactNumber(String contactNumber);
	
	public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;

	public boolean accountExistsById(String accountId);
	public boolean deleteAccountById(String accountId) throws IdNotFoundException;
}