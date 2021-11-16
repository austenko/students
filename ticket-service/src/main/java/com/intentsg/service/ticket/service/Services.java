package com.intentsg.service.ticket.service;

import com.intentsg.model.Ticket;
import com.intentsg.service.ticket.dto.TicketDto;
import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Services {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDto allToTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketId(ticket.getTicketId());
        ticketDto.setTitle(ticket.getTitle());
        ticketDto.setPrice(ticket.getPrice());
        ticketDto.setCreationDate(ticket.getCreationDate());
        return ticketDto;
    }

    public List<TicketDto> getById(Long id) {
        List<TicketDto> list = ticketRepository.findByTicketId(id).stream()
                .map(e -> {
                    TicketDto userDto = new TicketDto();

                    userDto.setTicketId(e.getTicketId());
                    return userDto;
                }).collect(Collectors.toList());
        return list;
    }


    public List<TicketDto> getByTitle(String title) {
        List<TicketDto> list = ticketRepository.findByTitle(title).stream()
                .map(e -> {
                    TicketDto ticketDto = new TicketDto();

                    ticketDto.setTitle(e.getTitle());
                    return ticketDto;
                }).collect(Collectors.toList());
        return list;
    }
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }


    public List<TicketDto> getAll() {
        return ticketRepository.findAll().stream()
                .map(this::allToTicketDto)
                .collect(Collectors.toList());
    }

}
