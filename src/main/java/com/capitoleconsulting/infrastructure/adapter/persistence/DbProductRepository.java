package com.capitoleconsulting.infrastructure.adapter.persistence;

import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.ProductRepository;

@Repository
public class DbProductRepository implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public DbProductRepository(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Stream<ProductPrice> prices(Long productId, Long brandId) {
        return jpaProductRepository.prices(productId, brandId)
            .map(productPrice ->
                new ProductPrice(
                    productPrice.brandId(),
                    productPrice.startDate(),
                    productPrice.endDate(),
                    productPrice.priceList(),
                    productPrice.productId(),
                    productPrice.priority(),
                    productPrice.price(),
                    productPrice.currency()
                ));
    }

}