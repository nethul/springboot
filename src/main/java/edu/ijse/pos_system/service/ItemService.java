package edu.ijse.pos_system.service;

import java.util.List;
import org.springframework.stereotype.Service;

import edu.ijse.pos_system.entity.Item;

@Service
public interface ItemService {
    Item CreateItem(Item item);
    Item updateItem(Item item);
    void deleteItem(Long id);
    Item getItem(Long id);
    List<Item> getAllItems();
}
