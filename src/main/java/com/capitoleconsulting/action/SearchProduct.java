package com.capitoleconsulting.action;

import com.capitoleconsulting.domain.Product;
import com.capitoleconsulting.domain.ProductDTO;
import com.capitoleconsulting.domain.ProductRepository;
import com.capitoleconsulting.domain.exception.ProductNotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;

public class SearchProduct {

    private final ProductRepository productRepository;

    public SearchProduct(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO execute(String applicationDate, Long productId, Long brandId) {
        LocalDateTime date = LocalDateTime.parse(applicationDate);
        Product product = productRepository.searchProducts(productId, brandId)
            .stream()
            .filter(currentProduct -> currentProduct.dateIsBetween(date))
            .max(Comparator.comparing(Product::priority))
            .orElseThrow(ProductNotFoundException::new);
        return new ProductDTO(product);
    }

}