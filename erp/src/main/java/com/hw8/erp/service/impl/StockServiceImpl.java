package com.hw8.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw8.erp.entity.Stock;
import com.hw8.erp.repository.StockRepository;
import com.hw8.erp.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock reduceStock(Long productId, int quantity) {
        Stock stock = stockRepository.findByProductId(productId);
        if (stock == null) {
            throw new RuntimeException("Ürün stokta bulunmamaktadır.");
        }

        int newQuantity = stock.getQuantity() - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Yeterli miktarda ürün stokta bulunmamaktadır.");
        }

        stock.setQuantity(newQuantity);
        stockRepository.save(stock);

        return stock;
    }
}






