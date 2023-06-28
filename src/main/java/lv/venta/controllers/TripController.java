package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.models.Trip;
import lv.venta.services.TripService;

@Controller
@RequestMapping("/trip")
public class TripController {

	@Autowired
	private TripService tripService;

	@GetMapping("/showAll")
	public String selectAllTrips(org.springframework.ui.Model trip) {
		trip.addAttribute("MyTrips", tripService.selectAllTrips());
		return "trip-all-page";
	}

	@GetMapping("/showAll/today")
	public String selectAllTripsToday(org.springframework.ui.Model trip) {
		List<Trip> tripsToday = tripService.selectAllTripsToday();
		trip.addAttribute("MyTrips", tripsToday);
		return "trip-all-page";
	}
}
