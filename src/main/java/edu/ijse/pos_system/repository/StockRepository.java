package edu.ijse.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ijse.pos_system.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
    
}
