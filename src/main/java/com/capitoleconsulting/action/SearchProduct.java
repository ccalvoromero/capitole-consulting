package com.capitoleconsulting.action;

import java.util.Comparator;

import com.capitoleconsulting.domain.date.DateTime;
import com.capitoleconsulting.domain.entity.Prices;
import com.capitoleconsulting.domain.dto.ProductDTO;
import com.capitoleconsulting.domain.ProductRepository;
import com.capitoleconsulting.domain.exception.ProductNotFoundException;

public class SearchProduct {

    private final ProductRepository productRepository;

    public SearchProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO execute(String applicationDate, Long productId, Long brandId) {
        DateTime date = DateTime.of(applicationDate);
        Prices product = productRepository.searchProducts(productId, brandId)
            .stream()
            .filter(currentProduct -> date.isBetween(currentProduct.startDate(), currentProduct.endDate()))
            .max(Comparator.comparing(Prices::priority))
            .orElseThrow(ProductNotFoundException::new);
        return new ProductDTO(product);
    }

}