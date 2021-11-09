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
public class TestController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/findAll")
	@ApiOperation(value = "findAll", response = TicketDTO.class)
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
	@ApiOperation(value = "findById", response = TicketDTO.class)
	public TicketDTO findById(@PathVariable Long id){
		return ticketService.findById(id);
	}

	@PostMapping("/saveTicket")
	@ApiOperation(value = "saveTicket")
	public void saveTicket(@RequestParam String title, String description, String time){
		Ticket ticket = new Ticket();
		ticket.setDescription(description);
		ticket.setTime(time);
		ticket.setTitle(title);
		ticketService.saveTicket(ticket);
	}

	@GetMapping("/getByString")
	@ApiOperation(value = "getByString", response = TicketDTO.class)
	public List<TicketDTO> getByString(@RequestParam String text){
		return ticketService.findByAllField(text);
	}
}
