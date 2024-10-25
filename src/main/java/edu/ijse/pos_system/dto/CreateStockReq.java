package edu.ijse.pos_system.dto;

import edu.ijse.pos_system.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStockReq {
    private int availableQuantity;
    private Long itemId;
}
