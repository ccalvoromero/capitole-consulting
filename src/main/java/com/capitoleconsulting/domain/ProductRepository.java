package com.capitoleconsulting.domain;

import java.util.List;

public interface ProductRepository {
    List<Product> searchProducts(Long productId, Long brandId);
}