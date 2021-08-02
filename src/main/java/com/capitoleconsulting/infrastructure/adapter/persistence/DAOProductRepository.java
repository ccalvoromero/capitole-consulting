package com.capitoleconsulting.infrastructure.adapter.persistence;

import com.capitoleconsulting.domain.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOProductRepository extends JpaRepository<ProductPrice, Long> { }