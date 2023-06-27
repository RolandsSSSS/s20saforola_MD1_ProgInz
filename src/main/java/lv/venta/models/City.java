package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "city_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {

	@Setter(value = AccessLevel.NONE)
	private long idc;
	
	private String title;
	
	private String addressofstation;

	public City(String title, String addressofstation) {
		this.title = title;
		this.addressofstation = addressofstation;
	}
	
}
