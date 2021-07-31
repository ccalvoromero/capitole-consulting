package com.capitoleconsulting.domain;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {

    private Long id;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;

    public Product(Double price, LocalDateTime startDate, LocalDateTime endDate) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long id() {
        return this.id;
    }

    public Long brandId() {
        return this.brandId;
    }

    public LocalDateTime startDate() {
        return this.startDate;
    }

    public LocalDateTime endDate() {
        return this.endDate;
    }

    public Integer priceList() {
        return this.priceList;
    }

    public Long productId() {
        return this.productId;
    }

    public Integer priority() {
        return this.priority;
    }

    public Double price() {
        return this.price;
    }

    public String currency() {
        return this.currency;
    }

    public boolean dateIsBetween(LocalDateTime date){
        return this.endDate.isAfter(date) && this.startDate.isBefore(date);
    }

}