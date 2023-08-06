package com.hw8.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hw8.erp.entity.ProductPrice;
import com.hw8.erp.service.ProductPriceService;

@RestController
@RequestMapping("/api/product-prices")
public class ProductPriceController {

    private final ProductPriceService productPriceService;

    @Autowired
    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @PostMapping
    public ProductPrice addProductPrice(@RequestBody ProductPrice productPrice) {
        return productPriceService.addProductPrice(productPrice);
    }

    @GetMapping("/{id}")
    public ProductPrice getProductPriceById(@PathVariable Long id) {
        return productPriceService.getProductPriceById(id);
    }

    
}
