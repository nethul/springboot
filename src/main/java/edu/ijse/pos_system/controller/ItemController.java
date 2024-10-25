package edu.ijse.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ijse.pos_system.dto.CreateItemReq;
import edu.ijse.pos_system.entity.Category;
import edu.ijse.pos_system.entity.Item;
import edu.ijse.pos_system.service.CategoryService;
import edu.ijse.pos_system.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody CreateItemReq createItemReq){
        Category category = categoryService.getCategory(createItemReq.getCategoryId());
        
        Item item = new Item();
        item.setId(createItemReq.getId());
        item.setName(createItemReq.getName());
        item.setDescription(createItemReq.getDescription());
        item.setPrice(createItemReq.getPrice());
        item.setImgUrl(createItemReq.getImgUrl());
        item.setCategory(category);

        return ResponseEntity.status(201).body(itemService.CreateItem(item));
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        return ResponseEntity.status(201).body(itemService.getAllItems());
    }
}
