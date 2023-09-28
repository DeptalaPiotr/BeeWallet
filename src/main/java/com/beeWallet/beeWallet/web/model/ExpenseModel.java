package com.beeWallet.beeWallet.web.model;

import java.time.LocalDate;

public class ExpenseModel {

    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public enum ExpenseEnum {
        BEE("Pakiety lub odkłądy pszczele"),
        HONEY_EXTRACTOR("Miodarka"),
        SUPPLEMENTS("Lekarstwa/suplementy"),
        HIVE_AND_ELEMENTS("Ul lub elementy"),
        FOOD_FOR_BEES("Pokarm dla pszczół");

        private final String displayName;

        private ExpenseEnum(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
