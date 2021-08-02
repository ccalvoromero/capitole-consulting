package com.capitoleconsulting.action;

import java.util.Comparator;

import com.capitoleconsulting.domain.date.DateTime;
import com.capitoleconsulting.domain.ProductRepository;
import com.capitoleconsulting.domain.entity.ProductPrice;
import com.capitoleconsulting.domain.dto.ProductPriceResponse;
import com.capitoleconsulting.domain.exception.ProductPriceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SearchProductPrice {

    private final ProductRepository productRepository;

    public SearchProductPrice(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductPriceResponse execute(String applicationDate, Long productId, Long brandId) {
        DateTime date = DateTime.of(applicationDate);
        ProductPrice productPrice = productRepository.prices(productId, brandId)
            .stream()
            .filter(aProductPrice -> date.isBetween(aProductPrice.startDate(), aProductPrice.endDate()))
            .max(Comparator.comparing(ProductPrice::priority))
            .orElseThrow(ProductPriceNotFoundException::new);
        return new ProductPriceResponse(productPrice);
    }

}