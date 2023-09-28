package com.beeWallet.beeWallet.repository.entity;

import com.beeWallet.beeWallet.enums.ExpanseEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class ExpenseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private ExpanseEnum name;
    private Double price;
    private LocalDate date;

    public ExpenseEntity() {
    }

    public ExpenseEntity(ExpanseEnum name, Double price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public ExpanseEnum getName() {
        return name;
    }

    public void setName(ExpanseEnum name) {
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
        return "ExpenseModel{" +
                "name=" + name +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
