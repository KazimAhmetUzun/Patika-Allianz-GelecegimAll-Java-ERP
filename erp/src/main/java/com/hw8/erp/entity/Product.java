package com.hw8.erp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "is_kdv_applied")
    private boolean isKdvApplied;

    @Column(name = "kdv_applied_price")
    private int kdvAppliedPrice;

    @Column(name = "non_kdv_applied_price")
    private int nonKdvAppliedPrice;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKdvApplied() {
        return this.isKdvApplied;
    }

    public void setKdvApplied(boolean kdvApplied) {
        this.isKdvApplied = kdvApplied;
    }

    public int getKdvAppliedPrice() {
        return this.kdvAppliedPrice;
    }

    public void setKdvAppliedPrice(int kdvAppliedPrice) {
        this.kdvAppliedPrice = kdvAppliedPrice;
    }

    public int getNonKdvAppliedPrice() {
        return this.nonKdvAppliedPrice;
    }

    public void setNonKdvAppliedPrice(int nonKdvAppliedPrice) {
        this.nonKdvAppliedPrice = nonKdvAppliedPrice;
    }
}
