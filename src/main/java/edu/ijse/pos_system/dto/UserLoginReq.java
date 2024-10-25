package edu.ijse.pos_system.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserLoginReq {
    private String username;
}
