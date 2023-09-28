package com.beeWallet.beeWallet.web.model;

import com.beeWallet.beeWallet.enums.ExpenseEnum;

import java.time.LocalDate;

public class ExpenseModel {

   private ExpenseEnum name;
   private Double price;
   private LocalDate date;

    public ExpenseModel() {
    }

    public ExpenseModel(ExpenseEnum name, Double price, LocalDate date) {
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
