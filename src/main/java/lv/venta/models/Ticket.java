package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ticket_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ticket {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "idt")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idt;
	
	@Column(name = "PurchaseDateTime")
	@NotNull
	private String purchaseDateTime;
	
	@ManyToOne
	@JoinColumn(name = "idtr")
	private Trip trip;
	
	@Column(name = "Price")
	@NotNull
	private float price;
	
	@Column(name = "IsChild")
	@NotNull
	private boolean isChild;
	
	@ManyToOne
	@JoinColumn(name = "idc")
	private Cashier cashier;

	public Ticket(@NotNull String purchaseDateTime, Trip trip, @NotNull float price, @NotNull boolean isChild,
			Cashier cashier) {
		this.purchaseDateTime = purchaseDateTime;
		this.trip = trip;
		this.price = price;
		this.isChild = isChild;
		this.cashier = cashier;
	}
	

}
