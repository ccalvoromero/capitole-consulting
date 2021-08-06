package com.capitoleconsulting.domain.model;

import java.time.LocalDateTime;

public class ProductPrice {

    private final Long brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priceList;
    private final Long productId;
    private final Integer priority;
    private final Double price;
    private final String currency;
    private LocalDateTime lastUpdate;
    private String lastUpdateBy;

    public ProductPrice(
        Long brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList,
        Long productId, Integer priority, Double price, String currency) {
            this.brandId = brandId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.priceList = priceList;
            this.productId = productId;
            this.priority = priority;
            this.price = price;
            this.currency = currency;
    }

    public ProductPrice(
        Long brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Long productId,
        Integer priority, Double price, String currency, LocalDateTime lastUpdate, String lastUpdateBy) {
            this.brandId = brandId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.priceList = priceList;
            this.productId = productId;
            this.priority = priority;
            this.price = price;
            this.currency = currency;
            this.lastUpdate = lastUpdate;
            this.lastUpdateBy = lastUpdateBy;
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

    public LocalDateTime lastUpdate() {
        return this.lastUpdate;
    }

    public String lastUpdateBy() {
        return this.lastUpdateBy;
    }

    public boolean isActive(DateTime date) {
        return date.isBetween(this.startDate, this.endDate);
    }

}