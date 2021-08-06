package com.capitoleconsulting.action;

import org.springframework.stereotype.Component;
import com.capitoleconsulting.domain.port.ProductRepository;
import com.capitoleconsulting.domain.port.NewPriceRepository;

@Component
public class UpdatePrices {

    private final ProductRepository productRepository;
    private final NewPriceRepository newPriceRepository;

    public UpdatePrices(ProductRepository productRepository, NewPriceRepository newPriceRepository) {
        this.productRepository = productRepository;
        this.newPriceRepository = newPriceRepository;
    }

    public void execute(String source) {
        newPriceRepository.getUpdatedPrices(source).forEach(productRepository::update);
    }

}