package com.capitoleconsulting.action;

import java.util.Comparator;

import com.capitoleconsulting.domain.date.DateTime;
import com.capitoleconsulting.domain.entity.Product;
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
        Product product = productRepository.searchProducts(productId, brandId)
            .stream()
            .filter(currentProduct -> date.isBetween(currentProduct.startDate(), currentProduct.endDate()))
            .max(Comparator.comparing(Product::priority))
            .orElseThrow(ProductNotFoundException::new);
        return new ProductDTO(product);
    }

}