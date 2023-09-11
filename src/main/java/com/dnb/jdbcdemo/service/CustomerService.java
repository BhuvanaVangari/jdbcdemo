package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.dnb.jdbcdemo.dto.Customer;
import com.dnb.jdbcdemo.exceptions.InvalidAddressException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumberException;
import com.dnb.jdbcdemo.exceptions.InvalidCustomerIdException;
import com.dnb.jdbcdemo.exceptions.InvalidGovtIdException;

public interface CustomerService {
	public Customer createCustomer(Customer customer);

	public Optional<Customer> getCustomerById(int customerId) throws InvalidNameException, InvalidCustomerIdException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException;

	public List<Customer> getAllCustomers() throws InvalidNameException, InvalidCustomerIdException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException;

	public Optional<Customer> deleteCustomerById(int customerId) throws InvalidCustomerIdException, InvalidNameException,
			InvalidContactNumberException, InvalidAddressException, InvalidGovtIdException;
}
