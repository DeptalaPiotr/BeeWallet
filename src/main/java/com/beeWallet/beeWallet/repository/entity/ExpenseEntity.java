package com.beeWallet.beeWallet.repository.entity;

import com.beeWallet.beeWallet.enums.ExpenseEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class ExpenseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private ExpenseEnum name;
    private Double price;
    private LocalDate date;

    public ExpenseEntity() {
    }

    public ExpenseEntity(ExpenseEnum name, Double price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public ExpenseEnum getName() {
        return name;
    }

    public void setName(ExpenseEnum name) {
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
