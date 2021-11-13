package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@Api(value = "tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/findAll")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
					value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
					value = "Number of records per page.", defaultValue = "5"),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
					value = "Sorting criteria in the format: property(,asc|desc). ")
	})
	public List<TicketDTO> findAll(@ApiIgnore Pageable pageable) {
		return ticketService.getTicketsList(pageable);
	}

	@GetMapping("/{id}")
	public TicketDTO findById(@PathVariable Long id){
		return ticketService.findById(id);
	}

	@GetMapping("/getByString")
	public List<TicketDTO> getByString(@RequestParam String text){
		return ticketService.findByAllField(text);
	}

	@PostMapping("/saveTicket")
	public void saveTicket(@RequestBody Ticket ticket){
		ticketService.saveTicket(ticket);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id){
		ticketService.deleteById(id);
	}

}
