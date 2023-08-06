package com.hw8.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw8.erp.entity.ProductPrice;
import com.hw8.erp.repository.ProductPriceRepository;
import com.hw8.erp.service.ProductPriceService;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceServiceImpl(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    @Override
    public ProductPrice addProductPrice(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice getProductPriceById(Long id) {
        return productPriceRepository.findById(id).orElse(null);
    }

    
}
