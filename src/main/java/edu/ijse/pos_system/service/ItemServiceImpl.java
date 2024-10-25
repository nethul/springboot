package edu.ijse.pos_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ijse.pos_system.entity.Item;
import edu.ijse.pos_system.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item CreateItem(Item item) {
       return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        Item toBeUpdatedItem = itemRepository.findById(item.getId()).orElse(null);
        if (toBeUpdatedItem != null){
            toBeUpdatedItem.setName(item.getName());
            toBeUpdatedItem.setDescription(item.getDescription());
            toBeUpdatedItem.setPrice(item.getPrice());
            toBeUpdatedItem.setImgUrl(item.getImgUrl());
            return itemRepository.save(toBeUpdatedItem);
        }
        return null;
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
}
