package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.repository.TicketRepository;
import com.intentsg.service.ticket.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
@Api(value = "ticket-service")
public class TestController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/findAll")
    @ApiOperation(value = "The whole list of Tickets ", response = TicketDTO.class, tags = "findAll")
    public List<TicketDTO> findAll() {
        return ticketService.getAll();
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "Ticket found by ID ", response = TicketDTO.class, tags = "findById")
    public TicketDTO getById(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @GetMapping("/findByTitle/{title}")
    @ApiOperation(value = "Tickets found by Title ", response = TicketDTO.class, tags = "findByTitle")
    public List<TicketDTO> getByTitle(@PathVariable String title) {
        return ticketService.getByTitle(title);
    }

    @GetMapping("/findByField/{string}")
    @ApiOperation(value = "Tickets found by any Field ", response = TicketDTO.class, tags = "findByField")
    public List<TicketDTO> findByField(@PathVariable String string) {
        return ticketService.findByAllField(string);
    }

    @GetMapping("/findByPrice/{price}")
    @ApiOperation(value = "Tickets found by Price ", response = TicketDTO.class, tags = "findByPrice")
    public List<TicketDTO> getByPrice(@PathVariable String price) {
        return ticketService.getByPrice(price);
    }

    @GetMapping("/findByYear/{creationYear}")
    @ApiOperation(value = "Tickets found by year of creation ", response = TicketDTO.class, tags = "findByYear")
    public List<TicketDTO> getByYear(@PathVariable String creationYear) {
        return ticketService.getByYear(creationYear);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Ticket deleted by ID ", response = TicketDTO.class, tags = "deleteById")
    public void deleteById(@PathVariable Long id) {
        ticketService.deleteById(id);
    }

    @PostMapping("/saveTicket")
    @ApiOperation(value = "Save ticket ", response = TicketDTO.class, tags = "saveTicket")
    public void saveTicket(@RequestBody Ticket ticket) {
        ticketService.saveTicket(ticket);
    }
}
