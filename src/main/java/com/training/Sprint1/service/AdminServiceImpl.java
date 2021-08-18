package com.training.Sprint1.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.Sprint1.entities.Admin;
import com.training.Sprint1.entities.Cab;
import com.training.Sprint1.entities.CarType;
import com.training.Sprint1.entities.Customer;
import com.training.Sprint1.entities.Driver;
import com.training.Sprint1.entities.TripBooking;
import com.training.Sprint1.exception.DriverDoesNotExistException;
import com.training.Sprint1.exception.AdminNotFoundException;
import com.training.Sprint1.exception.CabNotFoundException;
import com.training.Sprint1.repository.AdminRepository;
import com.training.Sprint1.repository.ICabRepository;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.repository.ITripBookingRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
@Autowired
	private AdminRepository adminRepository;
@Autowired
    private ITripBookingRepository tripRepository;
@Autowired
    private ICabRepository cabRepository;
@Autowired
    private IDriverRepository driverRepository;

	@Override
	public List<Admin> getAllAdmin() {
		
		return adminRepository.findAll();
	}

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Optional<Admin> getAdminById(Long id) {
			return adminRepository.findById(id);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Admin deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin deletedAdmin = null;
		try {
		deletedAdmin = adminRepository.findById(admin.getId()).orElseThrow(AdminNotFoundException::new);
		adminRepository.delete(deletedAdmin); 
		
		} catch (AdminNotFoundException e) {

		e.printStackTrace();
		}
		
		return deletedAdmin;
	}
    
	@Override
    public Driver getDriverById(Long id) {
		Driver temp=null;
		try {
			 temp=driverRepository.findById(id).orElseThrow(DriverDoesNotExistException::new);
		} catch (DriverDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
    }
	
	@Override
	public List<TripBooking> getAllTrips() {
		// TODO Auto-generated method stub
		return tripRepository.findAll();
	}

	@Override
	public List<TripBooking> getTripsByCustomer(Customer customer){
	// TODO Auto-generated method stub
		return tripRepository.findAll();
	}

	@Override
	public List<Cab> getAllCabs() {
		// TODO Auto-generated method stub
		return cabRepository.findAll();
	}

	@Override
	public List<Cab> viewCabsOfType(CarType carType) {
		// TODO Auto-generated method stub
		return cabRepository.viewCabsOfType(carType);		
	}


	@Override
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		return driverRepository.findAll();
	}

	@Override
	public Driver addDriver(Driver driver) {
		// TODO Auto-generated method stub
		return driverRepository.save(driver);
	}

	@Override
	public Driver deleteDriver(Driver driver)  {
		Driver deletedDriver = null;
		try {
		deletedDriver = driverRepository.findById(driver.getId()).orElseThrow(DriverDoesNotExistException::new);
		driverRepository.delete(deletedDriver); 
		
		} catch (DriverDoesNotExistException e) {

			e.printStackTrace();
		}
		
		return deletedDriver;
	}
    @Override 
    public List<TripBooking> getTripDateWise(LocalDateTime date) {
    // TODO Auto-generated method stub
		return tripRepository.getTripDateWise(date);
	}
   
    

}