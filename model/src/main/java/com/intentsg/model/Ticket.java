package com.intentsg.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @Column(name = "TICKET_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CREATION_DATE", nullable = false)
    private String creationDate;

    @Column(name = "PRICE", nullable = false )
    private double price;

    @ManyToOne
    User userRelation;

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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
