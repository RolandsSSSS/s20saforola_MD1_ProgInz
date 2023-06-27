package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "driver_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Driver {
	
	@Setter(value = AccessLevel.NONE)
	private long idd;
	
	private String name;
	
	private String surname;
	
	private Buscategory categories;

	public Driver(String name, String surname, Buscategory categories) {
		this.name = name;
		this.surname = surname;
		this.categories = categories;
	}
	
	
}
