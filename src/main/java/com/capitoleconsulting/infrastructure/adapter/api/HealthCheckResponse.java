package com.capitoleconsulting.infrastructure.adapter.api;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthCheckResponse {

    @JsonProperty
    private final String applicationName = "capitole-consulting";

    @JsonProperty
    private final LocalDateTime dateTime = LocalDateTime.now();

    @JsonProperty
    private final String status = "UP!";

}