package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
	private long idt;
	
	private String purchasedatetime;
	
	private Trip trip;
	
	private float price;
	
	private boolean ischild;
	
	private Cashier cashier;
	
	//

	public Ticket(String purchasedatetime, Trip trip, float price, boolean ischild, Cashier cashier) {
		this.purchasedatetime = purchasedatetime;
		this.trip = trip;
		this.price = price;
		this.ischild = ischild;
		this.cashier = cashier;
	}

}
