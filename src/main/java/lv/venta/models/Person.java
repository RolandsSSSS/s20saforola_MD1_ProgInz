package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "person_table")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {
	
	private String name;
	
	private String surname;
	
}
