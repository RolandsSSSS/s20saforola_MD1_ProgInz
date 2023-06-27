package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	@Id
	@Column(name = "idtr")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idtr;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "trip_city_table", joinColumns = @JoinColumn(name = "idtr"), inverseJoinColumns = @JoinColumn(name = "idci"))
	private Collection<City> cities;
	
	@ManyToOne
	@JoinColumn(name = "idd")
	private Driver driver;
	
	@Column(name = "StartDateTime")
	@NotNull
	private String startDateTime;
	
	@Column(name = "Duration")
	@NotNull
	private float duration;
	
	@OneToMany(mappedBy =  "trip")
	private Collection<Ticket> tickets;

	public Trip(Collection<City> cities, Driver driver, @NotNull String startDateTime, @NotNull float duration) {
		this.cities = cities;
		this.driver = driver;
		this.startDateTime = startDateTime;
		this.duration = duration;
	}
	
}
