package com.intentsg.service.ticket.dto;

import com.intentsg.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    private Long id;
    private String title;
    private String description;
    private String time;
    private User user;
}
