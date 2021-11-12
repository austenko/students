package com.intentsg.service.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private long userDTOId;
    private String userDTO;

    public long getUserDTOId() {
        return userDTOId;
    }

    public void setUserDTOId(long userDTOId) {
        this.userDTOId = userDTOId;
    }

    public String getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(String userDTO) {
        this.userDTO = userDTO;
    }
}
