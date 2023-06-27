package lv.venta.models;


import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
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
public class Driver extends Person{
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idd")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idd;
	
	@NotBlank
	@Column(name = "Categories")
	private Buscategory categories;
	
	@OneToMany(mappedBy = "driver")
	private Collection<Trip> trips;

	public Driver(
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15) String name,
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15) String surname,
			@NotBlank Buscategory categories) {
		super(name, surname);
		this.categories = categories;
	}
	
}
