package com.intentsg.service.ticket.controller;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.repository.TicketRepository;
import com.intentsg.service.ticket.service.TicketService;
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

public class TestController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/findAll")
    public List<TicketDTO> findAll() {
        return ticketService.getAll();
    }

    @GetMapping("/findById/{id}")
    public TicketDTO getById(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @GetMapping("/findByTitle/{title}")
    public List<TicketDTO> getByTitle(@PathVariable String title) {
        return ticketService.getByTitle(title);
    }

    @GetMapping("/findByField/{string}")
    public List<TicketDTO> findByField(@PathVariable String string) {
        return ticketService.findByAllField(string);
    }

    @GetMapping("/findByPrice/{price}")
    public List<TicketDTO> getByPrice(@PathVariable String price) {
        return ticketService.getByPrice(price);
    }
}
