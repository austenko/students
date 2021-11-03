package com.intentsg.service.ticket.service;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketDTO> getTicketsList(){
        return ticketRepository.findAll().stream()
                .map(e -> {
                    TicketDTO ticketDTO = new TicketDTO();
                    ticketDTO.setDescription(e.getDescription());
                    ticketDTO.setTime(e.getTime());
                    ticketDTO.setTitle(e.getTitle());
                    ticketDTO.setUser(e.getUser());
                    ticketDTO.setId(e.getTicketId());
                    return ticketDTO;
                })
                .collect(Collectors.toList());
    }

    public TicketDTO getOne(Long id){
        TicketDTO ticketDTO = new TicketDTO();
        Ticket ticket = ticketRepository.getOne(id);
        ticketDTO.setId(ticket.getTicketId());
        ticketDTO.setTime(ticket.getTime());
        ticketDTO.setDescription(ticket.getDescription());
        ticketDTO.setTitle(ticket.getTitle());
        ticketDTO.setUser(ticket.getUser());
        return ticketDTO;
    }

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public List<Ticket> findByString(String text){
        return ticketRepository.findByString(text);
    }
}
