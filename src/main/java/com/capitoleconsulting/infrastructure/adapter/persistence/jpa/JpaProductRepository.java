package com.capitoleconsulting.infrastructure.adapter.persistence.jpa;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface JpaProductRepository extends JpaRepository<JpaProductPrice, Long> {

    @Query("SELECT p FROM JpaProductPrice p WHERE p.productId = :productId AND p.brandId = :brandId")
    Stream<JpaProductPrice> prices(Long productId, Long brandId);

    @Query(
        "UPDATE JpaProductPrice p " +
        "SET p.price = :price, p.priority = :priority, p.lastUpdate = :lastUpdate, p.lastUpdateBy = :lastUpdateBy " +
        "WHERE p.productId = :productId AND p.brandId = :brandId AND p.startDate = :startDate AND p.endDate = :endDate")
    @Transactional
    @Modifying
    void updatePrice(
        Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate,
        Double price, Integer priority, LocalDateTime lastUpdate, String lastUpdateBy);

}