package com.training.Sprint1.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.CustomerNotFoundException;
import com.training.Sprint1.exception.TripBookingNotFoundException;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.repository.ICustomerRepository;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.repository.ITripBookingRepository;

<<<<<<< HEAD
@SuppressWarnings("unused")
=======
>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
@Service
@Transactional
public class TripBookingService implements ITripBookingService{
	
	@Autowired
	private ITripBookingRepository tripBookingRepo;
	
	@Autowired
	private ICustomerRepository customerRepo;
	
	
	@Override
	public TripBooking addTripBooking(TripBooking tripbooking) {
		TripBooking newBooking = tripBookingRepo.save(tripbooking);
		return newBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripbooking) {
		TripBooking retrievedTripBookingDb = null;
		try {
		retrievedTripBookingDb = tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		retrievedTripBookingDb.setBill(tripbooking.getBill());
		retrievedTripBookingDb.setDistanceInKm(tripbooking.getDistanceInKm());
		retrievedTripBookingDb.setFromDateTime(tripbooking.getFromDateTime());
		retrievedTripBookingDb.setFromLocation(tripbooking.getFromLocation());
		retrievedTripBookingDb.setStatus(tripbooking.getStatus());
		retrievedTripBookingDb.setToDateTime(tripbooking.getToDateTime());
		retrievedTripBookingDb.setToLocation(tripbooking.getFromLocation());
		
		TripBooking updatedBooking = tripBookingRepo.save(retrievedTripBookingDb);
		return updatedBooking;
	}

	@Override
	public TripBooking deleteTripBooking(Long tripbookingId) {
		TripBooking retrVal = null;
		try {
			retrVal=tripBookingRepo.findById(tripbookingId).orElseThrow(TripBookingNotFoundException::new);
			if(retrVal==null) {
				throw new TripBookingNotFoundException();
			}else {
				tripBookingRepo.deleteAllById(null);
			}
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retrVal;
	}

	@Override
	public List<TripBooking> getTripsByCustomerId(Long id) {
		Customer customer;
		List<TripBooking> retVal=null;
		try {
			customer = customerRepo.findById(id).orElseThrow(CustomerNotFoundException::new);
			retVal = tripBookingRepo.findByCustomer(customer);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retVal;
	}

	@Override
	public TripBooking calculateBill(TripBooking tripbooking) {
		TripBooking retrVal = null;
		try {
			retrVal=tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
			if(retrVal==null) {
				throw new TripBookingNotFoundException();
			}else {
				Float bill = retrVal.getDistanceInKm()*retrVal.getCab().getPerKmRate();
				retrVal.setBill(bill);
				tripBookingRepo.save(retrVal);
			}
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retrVal;
	}

	@Override
	public List<TripBooking> getAllTrips() {
		List<TripBooking> retVal = null;
		retVal = tripBookingRepo.findAll();
		return retVal;
	}

	@Override
	public List<TripBooking> getTripDateWise(LocalDateTime date) {
		List<TripBooking> retVal = tripBookingRepo.getTripDateWise(date);
		return retVal;
	}

<<<<<<< HEAD
=======
	@Override
	public Float getDistanceInKm(TripBooking tripbooking) {
		TripBooking retVal = null;
		try {
			retVal = tripBookingRepo.findById(tripbooking.getId()).orElseThrow(TripBookingNotFoundException::new);
		} catch (TripBookingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal.getDistanceInKm();
	}

>>>>>>> 3f78c0ae3dea4d2a27cc58bc35e07772819557f4
}
