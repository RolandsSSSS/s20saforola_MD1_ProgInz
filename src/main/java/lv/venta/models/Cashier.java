package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "cashier_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cashier {
	
	@Setter(value = AccessLevel.NONE)
	private long idc;
	
	private String name;
	
	private String surname;

	public Cashier(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	
}
