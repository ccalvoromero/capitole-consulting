package com.capitoleconsulting.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST", nullable = false)
    private Integer priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    public ProductPrice(Double price, LocalDateTime startDate, LocalDateTime endDate) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ProductPrice(Long id, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, Long productId, Integer priority, Double price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public ProductPrice() { }

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

    public boolean isActive(DateTime date) {
        return date.isBetween(this.startDate, this.endDate);
    }

}