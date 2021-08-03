package com.capitoleconsulting.infrastructure.adapter.api.product;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.capitoleconsulting.domain.model.ProductPrice;

public class ProductPriceResponse {

    @JsonProperty
    private final Long productId;

    @JsonProperty
    private final Long brandId;

    @JsonProperty
    private final Integer priceId;

    @JsonProperty
    private final LocalDateTime startApplicationDate;

    @JsonProperty
    private final LocalDateTime endApplicationDate;

    @JsonProperty
    private final Double finalPrice;

    public ProductPriceResponse(ProductPrice product) {
        this.productId = product.productId();
        this.brandId = product.brandId();
        this.priceId = product.priceList();
        this.startApplicationDate = product.startDate();
        this.endApplicationDate = product.endDate();
        this.finalPrice = product.price();
    }

}