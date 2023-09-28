package com.beeWallet.beeWallet.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class IncomeEntity {

    @Id
    @GeneratedValue
    private Long id;
    private IncomenEnum name;
    private Double price;
    private LocalDate date;

    public IncomeEntity() {
    }

    public enum IncomenEnum {
    HONEY,
    PROPOLIS,
    BEE_POLLEN,
    BEES,
    HIVE_AND_ELEMENTS
}

    public IncomeEntity(IncomenEnum name, Double price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IncomenEnum getName() {
        return name;
    }

    public void setName(IncomenEnum name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IncomeModel{" +
                "name=" + name +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
