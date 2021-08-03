package com.capitoleconsulting.infrastructure.adapter.persistence;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class JpaProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
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

}