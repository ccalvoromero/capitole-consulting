package com.capitoleconsulting.infrastructure.adapter.api.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capitoleconsulting.action.SearchProductPrice;
import com.capitoleconsulting.domain.model.ProductPrice;

import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final SearchProductPrice searchProductPrice;

    public ProductController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping("/brands/{brandId}/products/{productId}")
    @Transactional(readOnly = true)
    public ResponseEntity<ProductPriceResponse> searchProductPrice(
        @RequestParam String applicationDate, @PathVariable Long productId, @PathVariable Long brandId) {
            ProductPrice productPrice = searchProductPrice.execute(applicationDate, productId, brandId);
            return new ResponseEntity<>(new ProductPriceResponse(productPrice), HttpStatus.OK);
    }

}