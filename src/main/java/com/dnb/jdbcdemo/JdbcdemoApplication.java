package com.dnb.jdbcdemo;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.CustomerService;

@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(JdbcdemoApplication.class, args);

		/*
		 * DataSource dataSource = applicationContext.getBean(DataSource.class);
		 * 
		 * System.out.println(dataSource!=null);
		 * 
		 * try {
		 * 
		 * System.out.println(dataSource.getConnection());
		 * 
		 * } catch (SQLException e) {
		 * 
		 * // TODO Auto-generated catch block
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */

		AccountService accountService = applicationContext.getBean(AccountService.class);

		CustomerService customerService = applicationContext.getBean(CustomerService.class);

		Account account2;

		Customer customer;

		try {
			account2 = new Account("aa124", "Boon", "Salary", 60100, "9036422722", "Hyd", LocalDate.now(),
					LocalDate.of(2001, 10, 22), 2);

			customer = new Customer(1, "Bhuvana", "9087654321", "Hydd", "BBBBB5111A", "778899006655");
			System.out.println(account2);
			Scanner sc = new Scanner(System.in);

			while (true) {

				System.out.println(
						"Enter your choice\n1)Create account\n2)Get accountby ID\n3)Delete account by ID\n4)Get all accounts\n5)Create Customer\n6)Get customer by ID\\n7)Delete customer by ID\n8)Get all customers\n9)Exit\n");

				int str = sc.nextInt();

				switch (str) {

				case 1:

					accountService.createAccount(account2);

					break;

				case 2: {

					Optional<Account> acc;

					acc = accountService.getAccountById("aa125");
					System.out.println(acc != null);
					break;

				}

				case 3: {

					accountService.deleteAccountById("aa125");
					break;

				}

				case 4: {

					accountService.getAllAccounts().forEach((name) -> System.out.println(name));
					break;
				}

				case 5: {
					customerService.createCustomer(customer);
					break;
				}
				
				case 6: {

					Optional<Customer> cus;

					cus = customerService.getCustomerById(1);
					System.out.println(cus != null);
					break;

				}

				case 7: {

					customerService.deleteCustomerById(1);
					break;

				}

				case 8: {

					customerService.getAllCustomers().forEach((name) -> System.out.println(name));
					break;
				}

				case 9:
					System.exit(0);

				}

			}
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAccountIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAccountTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidContactNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAccountStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCustomerIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidGovtIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * account2.setAccountId("sa003");
		 * 
		 * try {
		 * 
		 * account2.setAccountHolderName("Sathvika");
		 * 
		 * } catch (InvalidNameException e) {
		 * 
		 * // TODO Auto-generated catch block
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 * 
		 * account2.setAccountStatus(true);
		 * 
		 * account2.setAccountType("Savings");
		 * 
		 * account2.setAddress("Hyderabad");
		 * 
		 * account2.setBalance(60000);
		 * 
		 * account2.setContactNumber("9036470222");
		 * 
		 * try {
		 * 
		 * account2.setDob(LocalDate.of(2001, 14, 9)) ;
		 * 
		 * } catch (InvalidDateException e) {
		 * 
		 * // TODO Auto-generated catch block
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */

		// account2.setCustomer(new Customer(1,"vaish", "9123489343", "Bangalore",
		// "PDNJF42902", "37297207"));

	}

}
