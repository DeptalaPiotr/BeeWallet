package com.beeWallet.beeWallet.web.model;


import java.time.LocalDate;

public class IncomeModel {
    private IncomenEnum name;
    private Double price;
    private LocalDate date;

    public IncomeModel() {
    }

    public enum IncomenEnum {
    HONEY,
    PROPOLIS,
    BEE_POLLEN,
    BEES,
    HIVE_AND_ELEMENTS
}

    public IncomeModel(IncomenEnum name, Double price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
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


