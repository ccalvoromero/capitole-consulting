package com.capitoleconsulting.infrastructure.adapter.persistence.dao;

import com.capitoleconsulting.domain.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOProductRepository extends JpaRepository<ProductPrice, Long> { }