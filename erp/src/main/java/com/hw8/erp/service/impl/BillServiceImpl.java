package com.hw8.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw8.erp.entity.Bill;
import com.hw8.erp.entity.CustomerOrder;
import com.hw8.erp.entity.Product;
import com.hw8.erp.repository.BillRepository;
import com.hw8.erp.repository.CustomerOrderRepository;
import com.hw8.erp.repository.ProductRepository;
import com.hw8.erp.service.BillService;

@Service
public class BillServiceImpl implements BillService {

    private final CustomerOrderRepository customerOrderRepository;
    private final ProductRepository productRepository;
    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(
            CustomerOrderRepository customerOrderRepository,
            ProductRepository productRepository,
            BillRepository billRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.productRepository = productRepository;
        this.billRepository = billRepository;
    }

    @Override
    public Bill createBill(Long orderId) {
        CustomerOrder customerOrder = customerOrderRepository.findById(orderId).orElse(null);
        if (customerOrder == null) {
            throw new RuntimeException("Sipariş bulunamadı: " + orderId);
        }

        // Müşteri siparişinin bilgilerini al
        Long customerId = customerOrder.getCustomerId();
        
        // Siparişteki ürünleri al ve toplam fiyatı ve KDV hesaplamasını yap
        double totalAmount = 0;
        double totalKdv = 0;
        for (Long productId : customerOrder.getProductIds()) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product == null) {
                throw new RuntimeException("Ürün bulunamadı: " + productId);
            }
            totalAmount += product.isKdvApplied() ? product.getKdvAppliedPrice() : product.getNonKdvAppliedPrice();
            totalKdv += product.isKdvApplied() ? (product.getKdvAppliedPrice() * 0.18) : 0;
        }

        // Bill nesnesini oluştur ve bilgileri set et
        Bill bill = new Bill();
        bill.setOrderId(orderId);
        bill.setCustomerId(customerId);
        bill.setTotalAmount(totalAmount);
        bill.setTotalKdv(totalKdv);
        bill.setTotalWithKdv(totalAmount + totalKdv);

        // Bill'i veritabanına kaydet
        bill = billRepository.save(bill);

        return bill;
    }

    @Override
    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElse(null);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
