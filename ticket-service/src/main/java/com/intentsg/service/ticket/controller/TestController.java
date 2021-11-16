package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDto;
import com.intentsg.service.ticket.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TestController {

	@Autowired
	private Services services;

	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("ticket-service");
	}

	@GetMapping("/findAll")
	public List<TicketDto> findAll() {
		return services.getAll();
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<TicketDto>> getById(@PathVariable("ticketId") Long ticketId) {
		return ResponseEntity.ok(services.getById(ticketId));
	}


	@RequestMapping(value = "/findByTitle/{title}", method = RequestMethod.GET)
	public ResponseEntity<List<TicketDto>> getByString(@PathVariable("title") String title) {
		return ResponseEntity.ok(services.getByTitle(title));
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id){
		services.deleteById(id);
	}

}





