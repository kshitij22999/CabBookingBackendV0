package com.training.Sprint1;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import com.training.Sprint1.entities.*;
import com.training.Sprint1.repository.IDriverRepository;
import com.training.Sprint1.service.DriverService;

@SpringBootTest
class DriverTest {

	@Mock
	IDriverRepository repo;
	
	@InjectMocks
	DriverService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	Driver d1,d2,d3;
	List<Driver> driverList;
	List<Driver> bestDrivers;
	List<Driver> badDrivers;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		driverList = new ArrayList<>();
		
		d1 = new Driver("Hari", "DL2012MAH",4.9F ,new Cab(CarType.Alto, 12),VaccinationStatus.Not_Vaccinated);
		
		d2 = new Driver("Bhanu", "DL2018XYZ",3.7F, new Cab(CarType.SwiftDzire, 25), VaccinationStatus.SecondDose_Done);
		
		d3 = new Driver("HansRaj","DL2015GIF", 1.9F, new Cab(CarType.Etios, 18), VaccinationStatus.FirstDose_Done);
		
		driverList.add(d1);
		driverList.add(d2);
		driverList.add(d3);
	
		bestDrivers = new ArrayList<Driver>();
		bestDrivers.add(d1);
		
		badDrivers = new ArrayList<Driver>();
		badDrivers.add(d3);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	public void addDriverTest() {
		when(repo.save(d1)).thenReturn(d1);
		Assertions.assertEquals(d1,service.addDriver(d1));
	}
	
	@Test
	public void getAllDriversTest() {
		when(repo.findAll()).thenReturn(driverList);
		Assertions.assertEquals(3,service.getAllDrivers().size());
	}
	
	@Test
	public void updateDriverTest() {
		when(repo.findById(d1.getId())).thenReturn(Optional.of(d1));
		when(repo.save(d1)).thenReturn(d1);
		Assertions.assertEquals(d1,service.updateDriver(d1));

	}
	
	@Test
	public void getDriverByIdTest() {
		when(repo.findById(d1.getId())).thenReturn(Optional.of(d1));
		Assertions.assertEquals(d1, service.getDriverById(d1.getId()));	
		}
	
	@Test
	public void deleteDriverTest() {
		when(repo.findById(d1.getId())).thenReturn(Optional.of(d1));
		Assertions.assertEquals(d1 , service.deleteDriver(d1.getId()));
	}
	
	@Test
	public void getBestDriversTest() {
		when(repo.getBestDrivers()).thenReturn(bestDrivers);
		Assertions.assertEquals(1, service.getBestDrivers().size());
	}
	
}

	
	
