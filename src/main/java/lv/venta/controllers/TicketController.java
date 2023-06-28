package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.services.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/showAll")
	public String selectAllTickets(Model model) {
		model.addAttribute("MyTickets", ticketService.selectAllTickets());
		return "ticket-all-page";
	}

}
