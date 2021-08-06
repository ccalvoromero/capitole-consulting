package com.capitoleconsulting.domain.port;

import java.util.stream.Stream;
import com.capitoleconsulting.domain.model.ProductPrice;

public interface NewPriceRepository {
    Stream<ProductPrice> get(String source);
}