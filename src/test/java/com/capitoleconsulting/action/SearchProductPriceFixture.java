package com.capitoleconsulting.action;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import com.capitoleconsulting.domain.model.ProductPrice;

public class SearchProductPriceFixture {
    protected static final String anApplicationDate = "2020-06-14T10:00:00";
    protected static final Long aProductId = 35455L;
    protected static final Long aBrandId = 1L;
    protected static ProductPrice actualProductPrice;
    protected static final ProductPrice expectedProductPrice =
        new ProductPrice(35.50, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"));
    protected static final Stream<ProductPrice> expectedProducts =
        new ArrayList<ProductPrice>() {{
            add(new ProductPrice(35.50, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59")));
        }}.stream();
}