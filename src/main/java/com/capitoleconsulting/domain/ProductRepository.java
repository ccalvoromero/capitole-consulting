package com.capitoleconsulting.domain;

import com.capitoleconsulting.domain.entity.ProductPrice;

import java.util.List;

public interface ProductRepository  {
    List<ProductPrice> prices(Long productId, Long brandId);
}