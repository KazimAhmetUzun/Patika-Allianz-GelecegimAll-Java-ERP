package com.hw8.erp.service;

import com.hw8.erp.entity.ProductPrice;

public interface ProductPriceService {
    ProductPrice addProductPrice(ProductPrice productPrice);

    ProductPrice getProductPriceById(Long id);

    
}
