package lv.venta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITripRepo;

@Service
public class DriverCrudService implements IDriverCRUDService{
	
	@Autowired
	private IDriverRepo driverRepo;
	
	@Autowired
	private ITripRepo tripRepo;
	
	@Autowired
    public DriverCrudService(IDriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }
	

	@Override
	public List<Driver> selectAllDriver() {
		return (List<Driver>)driverRepo.findAll();
	}	

	@Override
	public Driver selectDriverById(long idd) {
		for(Driver driver : selectAllDriver()) {
			if(driver.getIdd()==idd) {
				return driver;
			}
		}
		return null;
	}

	@Override
	public void deleteDriverById(long idd) {
		for(Driver driver : selectAllDriver()) {
			if(driver.getIdd()==idd) {
				for(Trip trip : tripRepo.findAll()) {
					if(trip.getDriver().getIdd() == idd) {
						trip.setDriver(null);
						tripRepo.save(trip);
					}
				}
				driverRepo.delete(driver);
				break;
			}
		}
	}

	@Override
	public void insertNewDriver(Driver driver) {
		for(Driver driver2 : selectAllDriver()) {
			if(driver2.getName().equals(driver.getName()) && driver2.getSurname().equals(driver.getSurname()) && driver2.getCategories() == driver.getCategories()) {
				return;
			}
		}
		selectAllDriver().add(driver);
		driverRepo.save(driver);
	}

	@Override
	public void updateDriverById(long idd, Driver driverIn) {
		for(Driver driver : selectAllDriver()) {
			if(driver.getIdd()==idd) {
				if(driver != null) {
					driver.setName(driverIn.getName());
					driver.setSurname(driverIn.getSurname());
					driver.setCategories(driverIn.getCategories());
					
					selectAllDriver().add(driver);
					driverRepo.save(driver);
				}
			}
		}
	}

}
