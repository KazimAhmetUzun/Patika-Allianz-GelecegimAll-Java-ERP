package com.hw8.erp.service;

import java.util.List;

import com.hw8.erp.entity.Bill;

public interface BillService {
    List<Bill> getAllBills();
    Bill getBillById(Long id);
    Bill createBill(Long orderId);
}
