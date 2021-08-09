package com.capitoleconsulting.infrastructure.adapter.batch;

import com.capitoleconsulting.action.UpdatePrices;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class UpdatePricesBatch {

    private final UpdatePrices updatePrices;

    @Value("${batch.updateprice.csv}" )
    private String csvSource;

    public UpdatePricesBatch(UpdatePrices updatePrices) {
        this.updatePrices = updatePrices;
    }

    @Scheduled(fixedDelayString = "${batch.updateprice.time}")
    public void run() {
        updatePrices.execute(csvSource);
    }

}