package com.beeWallet.beeWallet.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class ExpenseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private String name;
    private Double price;

    public ExpenseEntity() {
    }

    public ExpenseEntity(Long id, LocalDate date, String name, Double price) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "ExpenseModel{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" +
                '}';
    }

    // TODO: 29.09.2023
    // Implement category
//    public enum CategoryEnum {
//        HONEY("Miód"),
//        PROPOLIS("Pierzga"),
//        BEE_POLLEN("Pyłek"),
//        BEES("Odkłady, pakiety pszczele"),
//        HIVE_AND_ELEMENTS("Ul lub elementy"),
//        SUPPLEMENTS("Lekarstwa/suplementy"),
//        FOOD_FOR_BEES("Pokarm dla pszczół");
//        private final String displayName;
//
//        private CategoryEnum(String displayName) {
//            this.displayName = displayName;
//        }
//
//        public String getDisplayName() {
//            return displayName;
//        }
//    }
}
