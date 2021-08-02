package com.capitoleconsulting.action;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.capitoleconsulting.domain.model.DateTime;
import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.ProductRepository;
import com.capitoleconsulting.domain.exception.ProductPriceNotFoundException;

@Component
public class SearchProductPrice {

    private final ProductRepository productRepository;

    public SearchProductPrice(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductPrice execute(String applicationDate, Long productId, Long brandId) {
        DateTime date = DateTime.of(applicationDate);
        return productRepository.prices(productId, brandId)
            .filter(aProductPrice -> aProductPrice.isActive(date))
            .max(Comparator.comparing(ProductPrice::priority))
            .orElseThrow(ProductPriceNotFoundException::new);
    }

}