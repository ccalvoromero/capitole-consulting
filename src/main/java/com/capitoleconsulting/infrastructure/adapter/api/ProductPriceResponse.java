package com.capitoleconsulting.infrastructure.adapter.api;

import java.time.LocalDateTime;
import com.capitoleconsulting.domain.model.ProductPrice;

public class ProductPriceResponse {

    private final Long productId;
    private final Long brandId;
    private final Integer priceId;
    private final LocalDateTime startApplicationDate;
    private final LocalDateTime endApplicationDate;
    private final Double finalPrice;

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
        return this.productId;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public Integer getPriceId() {
        return this.priceId;
    }

    public LocalDateTime getStartApplicationDate() {
        return this.startApplicationDate;
    }

    public LocalDateTime getEndApplicationDate() {
        return this.endApplicationDate;
    }

}