package com.hw8.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hw8.erp.entity.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    // Müşteri ID'sine göre siparişleri getiren bir metot
    List<CustomerOrder> findByCustomerId(Long customerId);    
}
