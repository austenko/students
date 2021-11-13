package com.intentsg.service.ticket.service;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDTO;
import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public TicketDTO findById(Long id){
        Ticket ticket = ticketRepository.getOne(id);
        return replaceToTicketDTO(ticket);
    }

    public List<TicketDTO> getTicketsList(Pageable pageable){
        return ticketRepository.findAll(pageable).stream()
                .map(this::replaceToTicketDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> findByAllField(String text){
        return ticketRepository.findByAllFieldRealization(text).stream()
                .map(this::replaceToTicketDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    private TicketDTO replaceToTicketDTO(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setDescription(ticket.getDescription());
        ticketDTO.setTime(ticket.getTime());
        ticketDTO.setTitle(ticket.getTitle());
        ticketDTO.setUser(ticket.getUser());
        ticketDTO.setId(ticket.getTicketId());
        return ticketDTO;
    }
}
