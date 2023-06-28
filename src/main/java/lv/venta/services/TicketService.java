package lv.venta.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;

@Service
public class TicketService implements ITicketService{
	
	@Autowired
	private ITicketRepo ticketRepo;
	
	@Autowired
    public TicketService(ITicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }
	
	@Override
	public List<Ticket> selectAllTickets() {
		return (List<Ticket>) ticketRepo.findAll();
	}
	
	@Override
	public List<Ticket> selectAllChildTickets() {
		List<Ticket> childtickets = new ArrayList<>();
		for(Ticket ticket : selectAllTickets()) {
			if(ticket.isChild()) {
				childtickets.add(ticket);
			}
		}
		return childtickets;
	}

	@Override
	public List<Ticket> selectAllTicketsWherePriceIsLow(float price) {
		List<Ticket> wherepriceislowtickets = new ArrayList<>();
		for(Ticket ticket : selectAllTickets()) {
			if(ticket.getPrice() < price) {
				wherepriceislowtickets.add(ticket);
			}
		}	
		return wherepriceislowtickets;
	}

	@Override
	public List<Ticket> selectAllTicketsByTripId(long idtr) {
		List<Ticket> ticketstripid = new ArrayList<>();
		for(Ticket ticket : selectAllTickets()) {
			if(ticket.getTrip().getIdtr() == idtr) {
				ticketstripid.add(ticket);
			}
		}
		return ticketstripid;
	}

	@Override
	public float calculateIncomeOfTripByTripId(long idtr) {
		float earnings = 0;
		for(Ticket ticket : selectAllTickets()) {
			if(ticket.getTrip().getIdtr() == idtr) {
				earnings = earnings + ticket.getPrice();
			}
		}
		return earnings;
	}

	@Override
	public float calculateIncomeOfCashierByCashierId(long idc) {
		float earnings = 0;
		for(Ticket ticket : selectAllTickets()) {
			if(ticket.getCashier().getIdc() == idc) {
				earnings = earnings + ticket.getPrice();
			}
		}
		return earnings;
	}

	@Override
	public void insertNewTicketByTripId(long idtr, Ticket ticket) {
		Ticket newticket = new Ticket(ticket.getPurchaseDateTime(), ticket.getTrip(), ticket.getPrice(), ticket.isChild(), ticket.getCashier());
		selectAllTickets().add(newticket);
		ticketRepo.save(newticket);
	}

}
