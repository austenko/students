package com.intentsg.service.ticket.service;

import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    @Autowired
   private TicketRepository ticketRepository;


}
