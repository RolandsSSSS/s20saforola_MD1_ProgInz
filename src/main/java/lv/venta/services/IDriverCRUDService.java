package lv.venta.services;

import java.util.List;

import lv.venta.models.Driver;

public interface IDriverCRUDService {

	List<Driver> selectAllDriver();

	Driver selectDriverById(long idd);
	
	void deleteDriverById(long idd);
	
	void insertNewDriver(Driver driver);
	
	void updateDriverById(long idd, Driver driver);
	
}
