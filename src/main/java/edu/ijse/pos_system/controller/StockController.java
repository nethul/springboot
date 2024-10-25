package edu.ijse.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ijse.pos_system.dto.CreateStockReq;
import edu.ijse.pos_system.entity.Stock;
import edu.ijse.pos_system.service.ItemService;
import edu.ijse.pos_system.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {
    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        return ResponseEntity.status(200).body(stockService.getAllStocks());
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody CreateStockReq createStockReq){
        System.out.println(createStockReq.toString());
        Stock stock = new Stock();
        stock.setItem(itemService.getItem(createStockReq.getItemId()));
        stock.setAvailableQuantity(createStockReq.getAvailableQuantity());
        
        Stock savedStock = stockService.saveStock(stock);
        return ResponseEntity.status(201).body(savedStock);
    }
}
