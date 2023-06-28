package lv.venta.services;

import java.util.List;

import lv.venta.models.Ticket;

public interface ITicketService {

	
	List<Ticket> selectAllChildTickets();
	
	List<Ticket> selectAllTicketsWherePriceIsLow(float price);
	
	List<Ticket> selectAllTicketsByTripId(long idtr);
	
	float calculateIncomeOfTripByTripId(long idtr);
	
	float calculateIncomeOfCashierByCashierId(long idc);
	
	void insertNewTicketByTripId(long idtr, Ticket ticket);
	
}
