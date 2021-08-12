package com.training.Sprint1.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
	enum VaccinationStatus{
	FirstDose_Done,SecondDose_Done,Not_Vaccinated;
	
}

@Entity
@Table(name="cba_driver")
public class Driver { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long driverId;
	private String driverName;
	private String lisenceNo;
	private float rating;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@OneToMany(cascade = CascadeType.ALL)
	private TripBooking tripbooking;
	
	@Enumerated
	private VaccinationStatus vaccinationStatus;
	
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public Driver(Long driverId, String driverName, String lisenceNo, float rating, Cab cab, TripBooking tripbooking,
			VaccinationStatus vaccinationStatus) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.rating = rating;
		this.cab = cab;
		this.tripbooking = tripbooking;
		this.vaccinationStatus = vaccinationStatus;
	}

	public Driver(String driverName, String lisenceNo, float rating, Cab cab, TripBooking tripbooking,
			VaccinationStatus vaccinationStatus) {
		super();
		this.driverName = driverName;
		this.lisenceNo = lisenceNo;
		this.rating = rating;
		this.cab = cab;
		this.tripbooking = tripbooking;
		this.vaccinationStatus = vaccinationStatus;
	}

	public Driver(String driverName, float rating, Cab cab, VaccinationStatus vaccinationStatus) {
		super();
		this.driverName = driverName;
		this.rating = rating;
		this.cab = cab;
		this.vaccinationStatus = vaccinationStatus;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getLisenceNo() {
		return lisenceNo;
	}

	public void setLisenceNo(String lisenceNo) {
		this.lisenceNo = lisenceNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public TripBooking getTripbooking() {
		return tripbooking;
	}

	public void setTripbooking(TripBooking tripbooking) {
		this.tripbooking = tripbooking;
	}

	public VaccinationStatus getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(VaccinationStatus vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", lisenceNo=" + lisenceNo + ", rating="
				+ rating + ", vaccinationStatus=" + vaccinationStatus + "]";
	}
	
	
	
	
}