package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	@Id
	@Column(name = "idci")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idci;
	
	@Column(name = "Title")
	@NotNull
	private String title;
	
	@Column(name = "AddressOfStation")
	@NotNull
	private String addressOfStation;
	
	@ManyToMany
	private Collection<Trip> trips;

	public City(@NotNull String title, @NotNull String addressOfStation) {
		this.title = title;
		this.addressOfStation = addressOfStation;
	}

}
