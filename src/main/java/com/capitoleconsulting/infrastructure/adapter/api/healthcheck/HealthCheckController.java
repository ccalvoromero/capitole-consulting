package com.capitoleconsulting.infrastructure.adapter.api.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public ResponseEntity<HealthCheckResponse> healthCheck() {
        return new ResponseEntity<>(new HealthCheckResponse(), HttpStatus.OK);
    }

}