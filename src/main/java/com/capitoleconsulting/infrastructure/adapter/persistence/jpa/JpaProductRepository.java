package com.capitoleconsulting.infrastructure.adapter.persistence.jpa;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProductPrice, Long> {

    @Query("SELECT p FROM JpaProductPrice p WHERE p.productId = :productId AND p.brandId = :brandId")
    Stream<JpaProductPrice> prices(Long productId, Long brandId);

}