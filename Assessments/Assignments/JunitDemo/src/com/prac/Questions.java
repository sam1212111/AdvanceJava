package com.prac;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questions {

    public List<List<String>> extractErrorLogs(List<List<String>> logs) {

        List<List<String>> filtered = new ArrayList<>();

        for (List<String> log : logs) {
            String status = log.get(2);
            if (status.equalsIgnoreCase("ERROR") || status.equalsIgnoreCase("CRITICAL")) {
                filtered.add(log);
            }
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

        Collections.sort(filtered, (a, b) -> {
            LocalDateTime dt1 = LocalDateTime.of(
                    LocalDate.parse(a.get(0), dateFormatter),
                    LocalTime.parse(a.get(1), timeFormatter)
            );

            LocalDateTime dt2 = LocalDateTime.of(
                    LocalDate.parse(b.get(0), dateFormatter),
                    LocalTime.parse(b.get(1), timeFormatter)
            );

            return dt1.compareTo(dt2);
        });

        return filtered;
    }
}
