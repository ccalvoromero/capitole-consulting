package com.capitoleconsulting.domain;

import com.capitoleconsulting.action.SearchProduct;

import com.capitoleconsulting.domain.dto.ProductDTO;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import static com.capitoleconsulting.domain.SearchProductFixture.*;

public class SearchProductTest {

    private SearchProduct searchProduct;
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository = Mockito.mock(ProductRepository.class);
        searchProduct = new SearchProduct(productRepository);
    }

   @Test
    public void search_product_price_on_the_14th_at_10am_successfully() {
       given_saved_products_in_a_repository();
       when_search_a_product_given_some_parameters(anApplicationDate, aProductId, aBrandId);
       then_the_product_price_is_equals_than_expected(expectedProduct, actualProduct);
    }

    private void given_saved_products_in_a_repository() {
        Mockito.when(productRepository.searchProducts(aProductId, aBrandId)).thenReturn(expectedProducts);
    }

    private void when_search_a_product_given_some_parameters(String applicationDate, Long productId, Long brandId) {
        actualProduct = searchProduct.execute(applicationDate, productId, brandId);
    }

    private void then_the_product_price_is_equals_than_expected(ProductDTO expected, ProductDTO actual) {
        Assertions.assertEquals(expected.finalPrice(), actual.finalPrice());
    }

}