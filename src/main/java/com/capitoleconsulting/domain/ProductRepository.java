package com.capitoleconsulting.domain;

import com.capitoleconsulting.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> searchProducts(Long productId, Long brandId);
}