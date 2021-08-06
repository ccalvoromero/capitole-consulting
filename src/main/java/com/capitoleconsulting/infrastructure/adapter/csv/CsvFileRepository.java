package com.capitoleconsulting.infrastructure.adapter.csv;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.NewPriceRepository;

public class CsvFileRepository implements NewPriceRepository {

    @Override
    public Stream<ProductPrice> get(String source) {
        List<ProductPrice> productsPrices = new ArrayList<>();
        File csvFile = new File(source);
        try (
            InputStream csvStream = new FileInputStream(csvFile);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(csvStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
         ) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            csvRecords.forEach(csvRecord -> {
                ProductPrice newProductPrice = new ProductPrice(
                    Long.valueOf(csvRecord.get("brandId")),
                    LocalDateTime.parse(csvRecord.get("startDate")),
                    LocalDateTime.parse(csvRecord.get("endDate")),
                    Integer.valueOf(csvRecord.get("priceList")),
                    Long.valueOf(csvRecord.get("productId")),
                    Integer.valueOf(csvRecord.get("priority")),
                    Double.valueOf(csvRecord.get("price")),
                    csvRecord.get("currency"),
                    LocalDateTime.parse(csvRecord.get("lastUpdate")),
                    csvRecord.get("lastUpdateBy")
                );
                productsPrices.add(newProductPrice);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
        return productsPrices.stream();
    }
}
