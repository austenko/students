package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TestController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/findAll")
	public List<TicketDTO> findAll() {
		return ticketService.getTicketsList();
	}

	@GetMapping("/{id}")
	public TicketDTO findOne(@PathVariable Long id){
		return ticketService.getOne(id);
	}

	@PostMapping("/saveTicket")
	public void saveTicket(@RequestParam String title, String description, String time){
		Ticket ticket = new Ticket();
		ticket.setDescription(description);
		ticket.setTime(time);
		ticket.setTitle(title);
		ticketService.saveTicket(ticket);
	}

	@GetMapping("/getByString")
	public List<Ticket> getByString(@RequestParam String text){
		return ticketService.findByString(text);
	}
}
