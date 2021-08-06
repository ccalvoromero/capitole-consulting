package com.capitoleconsulting.action;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.ProductRepository;
import com.capitoleconsulting.domain.exception.ProductPriceNotFoundException;

import static com.capitoleconsulting.action.SearchProductPriceFixture.*;

public class SearchProductPriceTest {

    private SearchProductPrice searchProductPrice;
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository = Mockito.mock(ProductRepository.class);
        searchProductPrice = new SearchProductPrice(productRepository);
    }

   @Test
    public void search_an_existing_product_returns_the_priority_price_successfully() {
       given_saved_products_in_a_repository();
       when_search_a_product_given_some_parameters(anApplicationDate, anExistingProductId, aBrandId);
       then_the_product_price_is_equals_than_expected(expectedProductPrice, actualProductPrice);
    }

    @Test
    public void search_an_invalid_product_price_throws_an_exception() {
        given_saved_products_in_a_repository();
        Assertions.assertThrows(ProductPriceNotFoundException.class, () ->
            when_search_a_product_given_some_parameters(anApplicationDate, aNonExistingProductId, aBrandId));
    }

    private void given_saved_products_in_a_repository() {
        Mockito.when(productRepository.prices(anExistingProductId, aBrandId)).thenReturn(expectedProducts);
    }

    private void when_search_a_product_given_some_parameters(String applicationDate, Long productId, Long brandId) {
        actualProductPrice = searchProductPrice.execute(applicationDate, productId, brandId);
    }

    private void then_the_product_price_is_equals_than_expected(ProductPrice expected, ProductPrice actual) {
        Assertions.assertEquals(expected.price(), actual.price());
    }

}