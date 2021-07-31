package com.capitoleconsulting.domain;

import com.capitoleconsulting.domain.dto.ProductDTO;
import com.capitoleconsulting.domain.entity.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class SearchProductFixture {
    protected static final String anApplicationDate = "2020-06-14T10:00:00";
    protected static final Long aProductId = 35455L;
    protected static final Long aBrandId = 1L;
    protected static ProductDTO actualProduct;
    protected static final ProductDTO expectedProduct = new ProductDTO(35.50);
    protected static final List<Product> expectedProducts =
        new ArrayList<Product>() {{
            add(new Product(35.50, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59")));
        }};
}