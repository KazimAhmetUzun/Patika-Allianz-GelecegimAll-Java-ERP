package com.hw8.erp.service;

import com.hw8.erp.entity.Stock;

public interface StockService {
    Stock reduceStock(Long productId, int quantity);
}
