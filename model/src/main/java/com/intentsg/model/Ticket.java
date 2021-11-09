package com.intentsg.model;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @Column(name = "TICKET_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(name = "TITLE", nullable = false)
    private String title;


    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
