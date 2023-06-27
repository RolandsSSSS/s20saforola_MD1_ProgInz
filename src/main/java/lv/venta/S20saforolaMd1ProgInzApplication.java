package lv.venta;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lv.venta.models.Buscategory;
import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.ICashierRepo;
import lv.venta.repos.ICityRepo;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;

@SpringBootApplication
public class S20saforolaMd1ProgInzApplication {

	public static void main(String[] args) {
		SpringApplication.run(S20saforolaMd1ProgInzApplication.class, args);
	}
	
	//@Bean // izsauks funkciju automatiski, kad startesies sistema
	public CommandLineRunner testModel(ICashierRepo cashierRepo, ICityRepo cityRepo, IDriverRepo driverRepo, ITicketRepo ticketRepo, ITripRepo tripRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
		
				Driver d1 = new Driver("Andris", "Volkovs", Buscategory.largebus);
				Driver d2 = new Driver("Rolands", "Ābols", Buscategory.schoolbus);
				Driver d3 = new Driver("Juris", "Sīpols", Buscategory.minibus);
				Driver d4 = new Driver("Salvis", "Akmens", Buscategory.largebus);
				driverRepo.save(d1);
				driverRepo.save(d2);
				driverRepo.save(d3);
				driverRepo.save(d4);
				
				
				Cashier c1 = new Cashier("Solveta", "Pride");
				Cashier c2 = new Cashier("Irita", "Liepa");
				Cashier c3 = new Cashier("Agnese", "Zveja");
				Cashier c4 = new Cashier("Salvis", "Apaļais");
				cashierRepo.save(c1);
				cashierRepo.save(c2);
				cashierRepo.save(c3);
				cashierRepo.save(c4);
				
				
				City ci1 = new City("Aizkraukle", "Spīdolas iela 7");
				City ci2 = new City("Kuldīga", "Adatu iela 8");
				City ci3 = new City("Rīga", "Upīša iela 21");
				City ci4 = new City("Jēkabpils", "Zemeņu iela 13");
				City ci5 = new City("Ventspils", "Inženieru iela 10");
				City ci6 = new City("Koknese", "Blaumaņu iela 14");
				City ci7 = new City("Tukums", "Dzelzceļa iela 34");
				City ci8 = new City("Talsi", "Pragas iela 2");
				City ci9 = new City("Saulkrasti", "Dzeņu iela 33");
				cityRepo.save(ci1);
				cityRepo.save(ci2);
				cityRepo.save(ci3);
				cityRepo.save(ci4);
				cityRepo.save(ci5);
				cityRepo.save(ci6);
				cityRepo.save(ci7);
				cityRepo.save(ci8);
				cityRepo.save(ci9);
				
				
				ArrayList<City> Rei1 = new ArrayList<>();
				ArrayList<City> Rei2 = new ArrayList<>();
				ArrayList<City> Rei3 = new ArrayList<>();
				ArrayList<City> Rei4 = new ArrayList<>();
				Rei1.add(ci3);
				Rei1.add(ci2);
				Rei1.add(ci8);
				Rei2.add(ci1);
				Rei2.add(ci6);
				Rei2.add(ci7);
				Rei3.add(ci4);
				Rei3.add(ci9);
				Rei3.add(ci5);
				Rei4.add(ci1);
				Rei4.add(ci9);
				Rei4.add(ci3);
				Rei4.add(ci5);
				
				
				Trip t1 = new Trip(Rei1, d4, "13/05/2023 12:00", (float) 0.6);
				Trip t2 = new Trip(Rei4, d2, "21/06/2023 13:00", (float) 5.2);
				Trip t3 = new Trip(Rei2, d3, "09/04/2023 11:00", (float) 3.8);
				Trip t4 = new Trip(Rei3, d1, "18/06/2023 16:00", (float) 1.3);
				tripRepo.save(t1);
				tripRepo.save(t2);
				tripRepo.save(t3);
				tripRepo.save(t4);
				
				
				Ticket tc1 = new Ticket("13/05/2023 11:30", t1, (float) 2.99, false, c1);
				Ticket tc2 = new Ticket("13/05/2023 10:00", t1, (float) 0.00, true, c1);
				Ticket tc3 = new Ticket("21/06/2023 12:00", t2, (float) 14.99, false, c3);
				Ticket tc4 = new Ticket("09/04/2023 09:00", t3, (float) 6.99, false, c4);
				Ticket tc5 = new Ticket("18/06/2023 14:00", t4, (float) 3.99, false, c2);
				ticketRepo.save(tc1);
				ticketRepo.save(tc2);
				ticketRepo.save(tc3);
				ticketRepo.save(tc4);
				ticketRepo.save(tc5);
				
			}
		};
	}

}
