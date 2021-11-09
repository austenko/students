package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.repository.TicketRepository;
import com.intentsg.service.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TestController {

	@Autowired
	private TicketService ticketService;



	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("ticket-service");

	}


}
