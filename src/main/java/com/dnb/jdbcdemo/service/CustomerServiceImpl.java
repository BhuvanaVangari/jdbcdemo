package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;
import com.dnb.jdbcdemo.repo.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerService customerService = null;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) throws InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() throws InvalidNameException, InvalidCustomerIdException, InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomers();
	}

	@Override
	public Optional<Customer> deleteCustomerById(int customerId) throws InvalidCustomerIdException, InvalidNameException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomerById(customerId);
	}

}
