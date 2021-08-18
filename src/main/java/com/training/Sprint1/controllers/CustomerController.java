package com.training.Sprint1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.CustomerNotFoundException;
//import com.training.Sprint1.exception.InvalidUserOrPasswordException;
import com.training.Sprint1.service.ICustomerService;
import com.training.Sprint1.service.ITripBookingService;
//import com.training.Sprint1.service.LoginService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/rest/api")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ITripBookingService tripbookingService;


	@PostMapping("/customers/insert")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		Customer insertedCustomer=customerService.insertCustomer(customer);
		return new ResponseEntity<Customer>(customerService.insertCustomer(insertedCustomer),HttpStatus.OK);
	}


	@PutMapping("/customers/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}


	@DeleteMapping("/customers/delete")
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.deleteCustomer(customer),HttpStatus.OK);
	}


	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.viewCustomers(), HttpStatus.OK);
	}


	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId")  Long customerId) throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId), HttpStatus.OK);
	}
	

	@PostMapping("customers/book/{id}")
	public ResponseEntity<TripBooking> addUnassignedTrip(@PathVariable("id") Long id,@RequestBody TripBooking tripbooking){
		TripBooking trip = tripbookingService.addUnassignedTripBooking(id, tripbooking);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	
	@GetMapping("customers/status/{id}")
	public ResponseEntity<TripBooking> checkStatusOfBooking(@PathVariable("id") Long id){
		TripBooking trip = tripbookingService.getTripBookingById(id);
		return new ResponseEntity<TripBooking>(trip,HttpStatus.OK);
	}
	
	@PostMapping("/customers/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		Customer temp = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/customers/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer){
		Customer temp = customerService.loginCustomer(customer);
		return new ResponseEntity<Customer>(temp,HttpStatus.OK);
	}
	
	@PutMapping("/customers/logout")
	public ResponseEntity<Customer> logoutCustomer(@RequestBody Customer customer){
		Customer temp = customerService.logoutCustomer(customer);
		return new ResponseEntity<Customer>(temp,HttpStatus.OK);
	}
}
