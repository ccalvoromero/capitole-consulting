package com.capitoleconsulting.infrastructure.adapter.dao;

import com.capitoleconsulting.domain.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOProductRepository extends JpaRepository<Prices, Long> { }