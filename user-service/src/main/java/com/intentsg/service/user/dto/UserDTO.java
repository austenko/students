package com.intentsg.service.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String client;

    public String getName() {
        return client;
    }

    public void setName(String client) {
        this.client = client;
    }
}
