package com.intentsg.service.ticket.service;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO toTicketDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getTicketId());
        ticketDTO.setTitle(ticket.getTitle());
        ticketDTO.setCreationYear(ticket.getCreationYear());
        ticketDTO.setPrice(ticket.getPrice());
        return ticketDTO;
    }

    public TicketDTO getById(Long id) {
        Ticket ticket = ticketRepository.getOne(id);
        return toTicketDTO(ticket);
    }

    public List<TicketDTO> getAll() {
        return ticketRepository.findAll().stream()
                .map(this::toTicketDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getByTitle(String title) {
        return ticketRepository.findByTitle(title).stream()
                .map(this::toTicketDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> findByAllField(String text) {
        return ticketRepository.findByAnyField(text).stream()
                .map(this::toTicketDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getByPrice(String price) {
        return ticketRepository.findByPrice(price).stream()
                .map(this::toTicketDTO)
                .collect(Collectors.toList());
    }
}
