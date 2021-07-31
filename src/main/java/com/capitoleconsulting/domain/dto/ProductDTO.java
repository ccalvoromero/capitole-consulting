package com.capitoleconsulting.domain.dto;

import com.capitoleconsulting.domain.entity.Product;

import java.time.LocalDateTime;

public class ProductDTO {

    private Long productId;
    private Long brandId;
    private Integer priceId;
    private LocalDateTime startApplicationDate;
    private LocalDateTime endApplicationDate;
    private final Double finalPrice;

    public ProductDTO(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public ProductDTO(Product product) {
        this.productId = product.productId();
        this.brandId = product.brandId();
        this.priceId = product.priceList();
        this.startApplicationDate = product.startDate();
        this.endApplicationDate = product.endDate();
        this.finalPrice = product.price();
    }

    public Double finalPrice() {
        return this.finalPrice;
    }

}