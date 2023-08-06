package com.hw8.erp.service;

import java.util.List;

import com.hw8.erp.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    Product updateProduct(Product product);
}
