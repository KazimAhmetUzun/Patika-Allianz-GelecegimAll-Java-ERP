package com.hw8.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hw8.erp.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
