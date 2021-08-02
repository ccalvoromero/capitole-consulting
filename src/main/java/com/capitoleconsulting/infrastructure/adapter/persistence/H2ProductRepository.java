package com.capitoleconsulting.infrastructure.adapter.persistence;

import java.util.stream.Stream;

import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.ProductRepository;

import org.springframework.stereotype.Repository;

@Repository
public class H2ProductRepository implements ProductRepository {

    private final DAOProductRepository daoProductRepository;

    public H2ProductRepository(DAOProductRepository daoProductRepository) {
        this.daoProductRepository = daoProductRepository;
    }

    @Override
    public Stream<ProductPrice> prices(Long productId, Long brandId) {
        return daoProductRepository.findAll().stream()
            .filter(product -> product.productId().equals(productId) && product.brandId().equals(brandId));
    }

}