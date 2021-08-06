package com.capitoleconsulting.action;

import com.capitoleconsulting.domain.model.ProductPrice;

import java.util.ArrayList;
import java.util.stream.Stream;

public class UpdatePricesFixture {

    protected static final String aSource = "src/main/resources/prices.csv";
    protected static final Stream<ProductPrice> productPrices = new ArrayList<ProductPrice>().stream();

}