package lv.venta.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.repos.ICityRepo;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITripRepo;

public class TripService implements ITripService{
	
	@Autowired
 	private IDriverRepo driverRepo;
	
	@Autowired
	private ITripRepo tripRepo;
	
	@Autowired
    public TripService(ITripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }
	
 
	public List<Trip> selectAllTrips(){
		return (List<Trip>) tripRepo.findAll();
	}

	@Override
	public List<Trip> selectAllTripsByCityTitle(String cTitle) {
		List<Trip> tripsbycity = new ArrayList<>();
		for(Trip trip : selectAllTrips()) {
			for(City city : trip.getCities()) {
				if(city.getTitle().equals(cTitle)) {
					tripsbycity.add(trip);
					break;
				}
			}
		}
		return tripsbycity;
	}

	@Override
	public List<Trip> selectAllTripsByDriverId(long idd) {
		List<Trip> tripsbydriver = new ArrayList<>();
		for(Trip trip : selectAllTrips()) {
			if(trip.getDriver().getIdd() == idd) {
				tripsbydriver.add(trip);
			}
		}
		return tripsbydriver;
	}

	@Override
	public List<Trip> selectAllTripsToday() {
		List<Trip> tripstoday = new ArrayList<>();
		LocalDate now = LocalDate.now();
		DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		for(Trip trip : selectAllTrips()) {
			LocalDate startDateTime = LocalDate.parse(trip.getStartDateTime(), myDateTimeFormatter);
			if(startDateTime.equals(now)) {
				tripstoday.add(trip);
			}
		}
		return tripstoday;
	}

	@Override
	public void changeTripDriverByDriverId(long idtr, long idd) {
		Trip trip2 = new Trip();
		Driver driver2 = new Driver();
		List<Driver> selectAllDrivers = (List<Driver>) driverRepo.findAll();
		for(Trip trip : selectAllTrips()) {
			if(trip.getIdtr() == idtr) {
				trip2 = trip;
				break;	
			}
		}
		
		for(Driver driver : selectAllDrivers) {
			if(driver.getIdd() == idd) {
				driver2 = driver;
				break;
			}
		}
		trip2.setDriver(driver2);
		tripRepo.save(trip2);
	}

}
