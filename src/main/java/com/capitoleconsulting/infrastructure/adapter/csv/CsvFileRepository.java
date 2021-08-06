package com.capitoleconsulting.infrastructure.adapter.csv;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.time.LocalDateTime;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.springframework.stereotype.Repository;
import com.capitoleconsulting.domain.model.ProductPrice;
import com.capitoleconsulting.domain.port.NewPriceRepository;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.csv.CSVFormat.DEFAULT;

@Repository
public class CsvFileRepository implements NewPriceRepository {

    @Override
    public Stream<ProductPrice> getUpdatedPrices(String source) {
        List<ProductPrice> productsPrices = new ArrayList<>();
        File csvFile = new File(source);
        try (
            InputStream csvStream = new FileInputStream(csvFile);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(csvStream, UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
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
