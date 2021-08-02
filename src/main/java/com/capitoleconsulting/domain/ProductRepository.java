package com.capitoleconsulting.domain;

import com.capitoleconsulting.domain.entity.Prices;

import java.util.List;

public interface ProductRepository  {
    List<Prices> searchProducts(Long productId, Long brandId);
}