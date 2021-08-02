package com.capitoleconsulting.infrastructure.adapter;

import com.capitoleconsulting.domain.entity.Prices;
import com.capitoleconsulting.domain.ProductRepository;

import com.capitoleconsulting.infrastructure.adapter.dao.DAOProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class H2ProductRepository implements ProductRepository {

    private final DAOProductRepository daoProductRepository;

    @Autowired
    public H2ProductRepository(DAOProductRepository daoProductRepository) {
        this.daoProductRepository = daoProductRepository;
    }

    @Override
    public List<Prices> searchProducts(Long productId, Long brandId) {
        return null;
    }

}