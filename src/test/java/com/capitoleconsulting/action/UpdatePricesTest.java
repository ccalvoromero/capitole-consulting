package com.capitoleconsulting.action;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.ProductRepository;
import com.capitoleconsulting.domain.port.NewPriceRepository;

import static org.mockito.ArgumentMatchers.any;
import static com.capitoleconsulting.action.UpdatePricesFixture.*;

public class UpdatePricesTest {

    private UpdatePrices updatePrices;
    private ProductRepository productRepository;
    private NewPriceRepository newPriceRepository;

    @BeforeEach
    void setup() {
        productRepository = Mockito.mock(ProductRepository.class);
        newPriceRepository = Mockito.mock(NewPriceRepository.class);
        updatePrices = new UpdatePrices(productRepository, newPriceRepository);
    }

    @Test
    public void update_product_prices_successfully() {
        given_updated_products_prices_in_a_repository();
        given_we_get_new_prices_from_a_repository();
        when_update_product_data_then_they_have_new_prices();
    }

    private void given_updated_products_prices_in_a_repository() {
        Mockito.doNothing().when(productRepository).update(any(ProductPrice.class));
    }

    private void given_we_get_new_prices_from_a_repository() {
        Mockito.when(newPriceRepository.get(aSource)).thenReturn(productPrices);
    }

    private void when_update_product_data_then_they_have_new_prices() {
        updatePrices.execute(aSource);
    }

}