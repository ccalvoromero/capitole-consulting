package com.capitoleconsulting.domain.date;

import java.time.LocalDateTime;

public class DateTime {

    private final LocalDateTime localDateTime;

    private DateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public static DateTime of(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        return new DateTime(localDateTime);
    }

    public boolean isBetween(LocalDateTime startDate, LocalDateTime endDate){
        return localDateTime.isAfter(startDate) && localDateTime.isBefore(endDate);
    }

}