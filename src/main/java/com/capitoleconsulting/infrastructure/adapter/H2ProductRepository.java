package com.capitoleconsulting.infrastructure.adapter;

import com.capitoleconsulting.domain.Product;
import com.capitoleconsulting.domain.ProductRepository;

import java.util.List;

public class H2ProductRepository implements ProductRepository {

    @Override
    public List<Product> searchProducts(Long productId, Long brandId) {
        return null;
    }

}
