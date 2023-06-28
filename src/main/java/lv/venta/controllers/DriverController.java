package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;
import lv.venta.models.Driver;
import lv.venta.services.DriverCrudService;

@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverCrudService driverService;

	@GetMapping("/showAll")
	public String selectAllDriver(org.springframework.ui.Model driver) {
		driver.addAttribute("MyDrivers", driverService.selectAllDriver());
		return "driver-all-page";
	}

	@GetMapping("/showAll/{id}")
	public String selectDriverById(@PathVariable long id, org.springframework.ui.Model driver) {
		driver.addAttribute("MyDrivers", driverService.selectDriverById(id));
		return "driver-one-page";
	}

	@GetMapping("/remove/{id}")
	public String deleteDriverById(@PathVariable("id") long id, org.springframework.ui.Model driver) {
		driverService.deleteDriverById(id);
		driver.addAttribute("MyDrivers", driverService.selectAllDriver());
		return "redirect:/driver/showAll";
	}

	@GetMapping("/addNew")
	public String showAddDriverForm(Driver driver) {
		return "driver-add-page";
	}

	@PostMapping("/addNew")
	public String addNewDriver(@Valid Driver driver, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "driver-add-page";
		}
		Driver newDriver = new Driver(driver.getName(), driver.getSurname(), driver.getCategories());
		driverService.insertNewDriver(newDriver);

		return "redirect:/driver/showAll";
	}

	@GetMapping("/update/{id}")
	public String updateDriverById(@PathVariable("id") long id, org.springframework.ui.Model driver) {
		Driver updatedDriver = driverService.selectDriverById(id);
		driver.addAttribute("updatedDriver", updatedDriver);
		return "driver-update-page";
	}

}
