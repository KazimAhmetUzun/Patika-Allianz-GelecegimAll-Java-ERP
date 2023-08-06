package com.hw8.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hw8.erp.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByProductId(Long productId);
}




