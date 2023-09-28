package com.beeWallet.beeWallet.repository.entity;

import com.beeWallet.beeWallet.enums.IncomenEnum;
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

    public IncomeEntity(IncomenEnum name, Double price, LocalDate date) {
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
