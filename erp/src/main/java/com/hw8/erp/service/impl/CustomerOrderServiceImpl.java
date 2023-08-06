package com.hw8.erp.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw8.erp.entity.CustomerOrder;
import com.hw8.erp.repository.CustomerOrderRepository;
import com.hw8.erp.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setCreationDate(LocalDateTime.now());
        customerOrder.setUpdateDate(LocalDateTime.now());
        customerOrder.setStatus("Pending"); // Initial status is set as "Pending"
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public void deleteCustomerOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }

    @Override
    public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder) {
        customerOrder.setUpdateDate(LocalDateTime.now());
        return customerOrderRepository.save(customerOrder);
    }

}
