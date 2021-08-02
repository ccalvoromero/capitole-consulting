package com.capitoleconsulting.action;

import com.capitoleconsulting.domain.port.ProductRepository;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import com.capitoleconsulting.domain.ProductPriceResponse;

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
    public void search_product_price_on_the_14th_at_10am_successfully() {
       given_saved_products_in_a_repository();
       when_search_a_product_given_some_parameters(anApplicationDate, aProductId, aBrandId);
       then_the_product_price_is_equals_than_expected(expectedProductPrice, actualProductPrice);
    }

    private void given_saved_products_in_a_repository() {
        Mockito.when(productRepository.prices(aProductId, aBrandId)).thenReturn(expectedProducts);
    }

    private void when_search_a_product_given_some_parameters(String applicationDate, Long productId, Long brandId) {
        actualProductPrice = searchProductPrice.execute(applicationDate, productId, brandId);
    }

    private void then_the_product_price_is_equals_than_expected(ProductPriceResponse expected, ProductPriceResponse actual) {
        Assertions.assertEquals(expected.getFinalPrice(), actual.getFinalPrice());
    }

}