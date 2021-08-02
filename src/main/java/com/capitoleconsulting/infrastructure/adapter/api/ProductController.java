package com.capitoleconsulting.infrastructure.adapter.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capitoleconsulting.action.SearchProductPrice;
import com.capitoleconsulting.domain.ProductPriceResponse;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final SearchProductPrice searchProductPrice;

    public ProductController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping("/brands/{brandId}/products/{productId}")
    public ResponseEntity<ProductPriceResponse> searchProductPrice(
        @RequestParam String applicationDate, @PathVariable Long productId, @PathVariable Long brandId) {
            ProductPriceResponse productPriceResponse = searchProductPrice.execute(applicationDate, productId, brandId);
            return new ResponseEntity<>(productPriceResponse, HttpStatus.OK);
    }

}