package com.capitoleconsulting.domain.port;

import java.util.stream.Stream;
import com.capitoleconsulting.domain.model.ProductPrice;

public interface ProductRepository  {
    Stream<ProductPrice> prices(Long productId, Long brandId);
    void update(ProductPrice productPrice);
}