package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TestController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/findAll")
	public List<TicketDTO> findAll(@NotNull final Pageable pageable) {
		return ticketService.getTicketsList(pageable);
	}

	@GetMapping("/{id}")
	public TicketDTO findById(@PathVariable Long id){
		return ticketService.findById(id);
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
	public List<TicketDTO> getByString(@RequestParam String text){
		return ticketService.findByAllField(text);
	}
}
