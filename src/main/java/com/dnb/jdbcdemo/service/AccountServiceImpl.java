package com.dnb.jdbcdemo.service;

import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.dto.Customer;
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
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.CustomerRepository;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

	@Autowired
//	@Qualifier
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Account createAccount(Account account) throws IdNotFoundException, InvalidNameException,
			InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
		// TODO Auto-generated method stub
		Optional<Customer> customer=customerRepository.findById(account.getCustomer().getCustomerId());
		
		if(customer.isPresent()) {
			account.setCustomer(customer.get());
			return accountRepository.save(account);
		}
		else {
			customer.orElseThrow(()->new IdNotFoundException("Customer id is not valid"));
		}
		
////		return accountRepository.save(account);
		return null;
	}

	@Override
	public Optional<Account> getAccountById(String accountId){// throws InvalidNameException, InvalidDateException,
//			InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException,
//			InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

	@Override
	public Iterable<Account> getAllAccounts() throws InvalidNameException, InvalidDateException,
			InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException,
			InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean deleteAccountById(String accountId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			if (accountRepository.existsById(accountId)) {
				return false;
			}
			return true;
		} else {
			throw new IdNotFoundException("AccountId not found");
		}
	}

	@Override
	public boolean accountExistsById(String accountId) {
		// TODO Auto-generated method stub
		if (accountRepository.existsById(accountId)) return true;
		else return false;
	}

	@Override
	public Optional<Account> getAccountByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByContactNumber(contactNumber);
	}

	@Override
	public Iterable<Account> getAllAccountsByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findAllByContactNumber(contactNumber);
	}

	// private static AccountService accountService = null;

//	@Autowired
//	AccountRepository accountRepository;
//	@Autowired
//	private CustomerRepository customerRepository;
////	private AccountServiceImpl() {
////
////	}
////
////	public static AccountService getInstance() {
////		synchronized (AccountServiceImpl.class) {
////			if (accountService == null) {
////				accountService = new AccountServiceImpl();
////			}
////		}
////
////		return accountService;
////	}
//
//	@Override
//	public Account createAccount(Account account) throws IdNotFoundException, InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
//		// AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
//		Optional<Customer> optional = customerRepository.getCustomerById(account.getCustomer().getCustomerId());
//
//		if (optional.isPresent()) {
//			return accountRepository.createAccount(account);
//		}
//
//		else {
//			throw new IdNotFoundException("Customer id not found");
//		}
//	}
//
//	@Override
//	public Optional<Account> getAccountById(String accountId) throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
//		// AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
//		return accountRepository.getAccountById(accountId);
//	}
//
//	@Override
//	public List<Account> getAllAccounts() throws InvalidNameException, InvalidDateException, InvalidAccountIdException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException, InvalidAddressException, InvalidAccountStatusException {
//		// TODO Auto-generated method stub
//		// AccountRepository accountRepository=AccountRepositoryImpl.getInstance();
//		return accountRepository.getAllAccounts();
//	}
//
//	@Override
//	public Optional<Account> deleteAccountById(String accountId) throws InvalidAccountIdException, InvalidNameException,
//			InvalidDateException, InvalidAccountTypeException, InvalidBalanceException, InvalidContactNumberException,
//			InvalidAddressException, InvalidAccountStatusException {
//		// TODO Auto-generated method stub
//		return accountRepository.deleteAccountById(accountId);
//	}
}
