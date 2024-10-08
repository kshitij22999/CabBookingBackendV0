package com.training.Sprint1;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.Sprint1.entities.Address;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.repository.ICustomerRepository;
import com.training.Sprint1.service.ICustomerServiceImpl;

@SuppressWarnings("unused")
@SpringBootTest
public class CustomerTest {
	
	@Mock
	ICustomerRepository customerRepo;
	
	@InjectMocks
	ICustomerServiceImpl customerService;
	
	List<Customer> customerList;
	Customer cust1, cust2, cust3;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		customerList = new ArrayList<>();
		cust1 = new Customer("Naveenreddy", "1234567@","9876543210","naveen219@gmail.com",new Address("4-108, Angathi street, Maharani Peta", "Vishakhapatnam", "Andhra Pradesh", "530002"));
		cust2 = new Customer( "Rohithvarma", "984979#)", "91234567890","rohith908@gmail.com",new Address("1-112, Rajagopalachari street, Governorpet,2 Town", "Vijayawada", "Andhra Pradesh", "520002"));
		cust3 = new Customer( "VamsiKrishna", "8019910@#","7845321489","vamsi785@gmail.com",new Address("3-729, Lakdikapul Road,Taj Enclave,Khairatabad", "Hyderabad", "Telangana", "500004"));
		
		customerList.add(cust1);
		customerList.add(cust2);
		customerList.add(cust3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void viewCustomersTest() throws CustomerNotFoundException {
		when(customerRepo.findAll()).thenReturn(customerList);
		Assertions.assertEquals(3,customerService.viewCustomers().size());
	}
	
	@Test
	public void viewCustomerTest() throws CustomerNotFoundException {
		when(customerRepo.findById(cust1.getId())).thenReturn(Optional.of(cust1));
		Assertions.assertEquals(cust1,customerService.viewCustomer(cust1.getId()));
	}
	
	@Test
	public void insertCustomerTest() {
		when(customerRepo.save(cust1)).thenReturn(cust1);
		Assertions.assertEquals(cust1,customerService.insertCustomer(cust1));
	}
	
	@Test
	public void deleteCustomerTest() throws CustomerNotFoundException {
		when(customerRepo.findById(cust1.getId())).thenReturn(Optional.of(cust1));
		Assertions.assertEquals(cust1,customerService.deleteCustomer(cust1));
	}
	
	@Test
	public void updateCustomerTest() throws CustomerNotFoundException {
		when(customerRepo.findById(cust1.getId())).thenReturn(Optional.of(cust1));
		when(customerRepo.save(cust1)).thenReturn(cust3);
		Assertions.assertEquals(cust3,customerService.updateCustomer(cust1));
	}
	
	
}
