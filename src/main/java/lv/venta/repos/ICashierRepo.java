package lv.venta.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Cashier;
import lv.venta.models.Driver;

public interface ICashierRepo extends CrudRepository<Cashier, Long>{

}
