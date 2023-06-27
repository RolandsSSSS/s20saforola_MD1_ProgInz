package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "trip_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trip {
	
	@Setter(value = AccessLevel.NONE)
	private long idtr;
	
	private City cities;
	
	private Driver driver;
	
	private String startdatetime;
	
	private int duration;

	public Trip(City cities, Driver driver, String startdatetime, int duration) {
		this.cities = cities;
		this.driver = driver;
		this.startdatetime = startdatetime;
		this.duration = duration;
	}
	
}
