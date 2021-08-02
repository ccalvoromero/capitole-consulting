package com.capitoleconsulting.domain.port;

import com.capitoleconsulting.domain.model.ProductPrice;

import java.util.stream.Stream;

public interface ProductRepository  {
    Stream<ProductPrice> prices(Long productId, Long brandId);
}