package edu.ijse.pos_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ijse.pos_system.entity.Stock;

@Service
public interface StockService {
    Stock saveStock(Stock stock);
    Stock updateStock(Stock stock);
    void deleteStock(Long id);
    Stock getStockById(Long id);
    List<Stock> getAllStocks();
}
