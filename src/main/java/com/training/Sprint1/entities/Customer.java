package com.training.Sprint1.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Table(name="cba_customer")
@Entity
public class Customer extends User {
<<<<<<< HEAD
private String customerName;
=======
	
	private String customerName;
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
	
	@OneToMany(mappedBy = "customer")
	private List<TripBooking> tripBookings;
	
	public List<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(List<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	public Customer() {
		super();
<<<<<<< HEAD
	}

	public Customer(Long customerId, String customerName) {
		super(customerId);

		this.customerName = customerName;
	}
	





	public Customer(String username, String password, String mobileNumber, String email, Address address) {
		super(username, password, mobileNumber, email, address);
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

=======
	}

	public Customer(Long customerId, String customerName) {
		super(customerId);

		this.customerName = customerName;
	}





	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
	
}
