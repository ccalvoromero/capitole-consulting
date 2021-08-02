package com.capitoleconsulting.infrastructure.adapter.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.capitoleconsulting.domain.ProductRepository;
import com.capitoleconsulting.domain.entity.ProductPrice;

import com.capitoleconsulting.infrastructure.adapter.persistence.dao.DAOProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class H2ProductRepository implements ProductRepository {

    private final DAOProductRepository daoProductRepository;

    @Autowired
    public H2ProductRepository(DAOProductRepository daoProductRepository) {
        this.daoProductRepository = daoProductRepository;
    }

    @Override
    public List<ProductPrice> prices(Long productId, Long brandId) {
        return daoProductRepository.findAll()
            .stream()
            .filter(product -> product.productId().equals(productId) && product.brandId().equals(brandId))
            .collect(Collectors.toList());
    }

}