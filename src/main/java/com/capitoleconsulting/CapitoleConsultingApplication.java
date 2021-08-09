package com.capitoleconsulting;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
public class CapitoleConsultingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapitoleConsultingApplication.class, args);
    }

}