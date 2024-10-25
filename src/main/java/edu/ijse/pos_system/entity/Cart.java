package edu.ijse.pos_system.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<Item> items;

    @OneToOne
    private User user;
}
