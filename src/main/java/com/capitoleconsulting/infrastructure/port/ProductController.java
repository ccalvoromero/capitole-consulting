package com.capitoleconsulting.infrastructure.port;

import com.capitoleconsulting.action.SearchProductPrice;
import com.capitoleconsulting.domain.dto.ProductPriceResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final SearchProductPrice searchProductPrice;

    @Autowired
    public ProductController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping("/brands/{brandId}/products/{productId}")
    public ResponseEntity<ProductPriceResponse> price(@RequestParam String applicationDate, @PathVariable Long productId, @PathVariable Long brandId) {
        ProductPriceResponse productPriceResponse = searchProductPrice.execute(applicationDate, productId, brandId);
        return new ResponseEntity<>(productPriceResponse, HttpStatus.OK);
    }

}