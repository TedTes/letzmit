package com.tutego.date4u.rest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Optional;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tutego.date4u.interfaces.ProfileRepository;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ProblemDetail;
import org.springframework.http.HttpStatus;
import java.net.URI;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LastSeenStatistics {
    @Autowired
    private ProfileRepository profiles;

    public static class Data {
        @JsonProperty("x")
        public YearMonth yearMonth;
        @JsonProperty("y")
        public int count;

        public Data() {
        }

        public Data(YearMonth yearMonth, int count) {
            this.yearMonth = yearMonth;
            this.count = count;
        }
    }

    public List<Data> data;

    public LastSeenStatistics() {
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> yearMonthMisformatted(MethodArgumentTypeMismatchException e) {
        System.out.println("Heyyyyy");
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("The format of the argument '" + e.getName() + "' is wrong");
        problem.setDetail("The format of '" + e.getValue()+ "' is invalid. The formatstring must match ISO 8601 format 'YYYY-MM', like '2025-03'");
        problem.setType(URI.create("https://www.iso.org/iso-8601-date-and-time-format.html"));
        return ResponseEntity.of(problem).build();
    }

    @GetMapping(path = "/api/stat/last-seen", produces = MediaType.APPLICATION_JSON_VALUE)
    public LastSeenStatistics lastSeenStatistics(@RequestParam("start") YearMonth start,
            @RequestParam("end") YearMonth end) {
        // YearMonth start = optionalStart.map(YearMonth::parse)
        // .orElse(YearMonth.now().minusYears(2));
        // YearMonth end = optionalEnd.map(YearMonth::parse)
        // .orElse(YearMonth.now());
        System.out.println("test test test");
        System.out.println(start);
        System.out.println(end);
        // return new LastSeenStatistics(
        // Arrays.asList(new LastSeenStatistics.Data(YearMonth.now(),
        // 100)));
        List<Data> data = profiles.findMonthlyProfileCount(start.atDay(1).atStartOfDay(),
                end.atEndOfMonth().plusDays(1).atStartOfDay()).stream().map(tuple -> {
                    return new Data(
                            YearMonth.of(
                                    Integer.parseInt(tuple.get("y").toString()),
                                    Integer.parseInt(tuple.get("m").toString())),
                            Integer.parseInt(tuple.get("count").toString()));
                }).toList();
        // YearMonth start = YearMonth.now().minusYears(2);
        // YearMonth end = YearMonth.now();
        // ThreadLocalRandom rnd = ThreadLocalRandom.current();
        // List<Data> data = Stream.iterate(start, o -> o.plusMonths(1))
        // .limit(start.until(end, ChronoUnit.MONTHS) + 1)
        // .map(yearMonth -> new LastSeenStatistics.Data(
        // yearMonth, rnd.nextInt(1000, 10000)))
        // .toList();
        return new LastSeenStatistics(data);
    }

    public LastSeenStatistics(List<Data> data) {
        this.data = data;
    }
}
