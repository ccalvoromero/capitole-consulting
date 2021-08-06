package com.capitoleconsulting.infrastructure.adapter.persistence;

import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.ProductRepository;
import com.capitoleconsulting.infrastructure.adapter.persistence.jpa.JpaProductRepository;

@Repository
public class DbProductRepository implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public DbProductRepository(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Stream<ProductPrice> prices(Long productId, Long brandId) {
        return jpaProductRepository.prices(productId, brandId)
            .map(jpaProductPrice ->
                new ProductPrice(
                    jpaProductPrice.brandId(),
                    jpaProductPrice.startDate(),
                    jpaProductPrice.endDate(),
                    jpaProductPrice.priceList(),
                    jpaProductPrice.productId(),
                    jpaProductPrice.priority(),
                    jpaProductPrice.price(),
                    jpaProductPrice.currency()
                ));
    }

    @Override
    public void update(ProductPrice productPrice) {
        jpaProductRepository.updatePrice(
            productPrice.productId(),
            productPrice.brandId(),
            productPrice.startDate(),
            productPrice.endDate(),
            productPrice.price(),
            productPrice.priority(),
            productPrice.lastUpdate(),
            productPrice.lastUpdateBy()
        );
    }

}