package edu.ijse.pos_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemReq {
    private Long id;

    private String name;

    private String description;

    
    private Double price;

    private String imgUrl;

    private Long categoryId;
}
