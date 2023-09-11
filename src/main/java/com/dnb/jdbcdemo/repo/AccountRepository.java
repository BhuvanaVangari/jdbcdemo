package com.dnb.jdbcdemo.repo;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.exceptions.InvalidAccountIdException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountStatusException;
import com.dnb.jdbcdemo.exceptions.InvalidAccountTypeException;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidBalanceException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidDateException;

public interface AccountRepository {

	public Account createAccount(Account account);
	
	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
	
	public List<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
	
	public Optional<Account> deleteAccountById(String accountId) throws InvalidAccountIdException, InvalidNameException, InvalidDateException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException;
}
