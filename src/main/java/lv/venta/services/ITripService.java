package lv.venta.services;

import java.util.List;

import lv.venta.models.Trip;

public interface ITripService {

	List<Trip> selectAllTripsByCityTitle(String cTitle);
	
	List<Trip> selectAllTripsByDriverId(long idd);
	
	List<Trip> selectAllTripsToday();
	
	void changeTripDriverByDriverId(long idtr, long idd);
	
}
