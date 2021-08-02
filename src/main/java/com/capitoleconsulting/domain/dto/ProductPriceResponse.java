package com.capitoleconsulting.domain.dto;

import com.capitoleconsulting.domain.entity.ProductPrice;

import java.time.LocalDateTime;

public class ProductPriceResponse {

    private Long productId;
    private Long brandId;
    private Integer priceId;
    private LocalDateTime startApplicationDate;
    private LocalDateTime endApplicationDate;
    private final Double finalPrice;

    public ProductPriceResponse(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public ProductPriceResponse(ProductPrice product) {
        this.productId = product.productId();
        this.brandId = product.brandId();
        this.priceId = product.priceList();
        this.startApplicationDate = product.startDate();
        this.endApplicationDate = product.endDate();
        this.finalPrice = product.price();
    }

    public Double getFinalPrice() {
        return this.finalPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public LocalDateTime getStartApplicationDate() {
        return startApplicationDate;
    }

    public LocalDateTime getEndApplicationDate() {
        return endApplicationDate;
    }
}