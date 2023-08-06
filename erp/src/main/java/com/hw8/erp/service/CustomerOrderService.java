package com.hw8.erp.service;

import java.util.List;

import com.hw8.erp.entity.CustomerOrder;

public interface CustomerOrderService {
    List<CustomerOrder> getAllCustomerOrders();
    CustomerOrder getCustomerOrderById(Long id);
    CustomerOrder saveCustomerOrder(CustomerOrder customerOrder);
    void deleteCustomerOrder(Long id);
    CustomerOrder updateCustomerOrder(CustomerOrder customerOrder);
}
