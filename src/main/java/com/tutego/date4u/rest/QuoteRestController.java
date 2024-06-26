package com.tutego.date4u.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.tutego.date4u.core.Quotes;

@RestController
@RequestMapping("/api/quotes")
public class QuoteRestController {
    @Autowired
    Quotes quotes;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quote founddddd")
    class QuoteNotFoundException extends ResponseStatusException {
        public QuoteNotFoundException(String reason) {
            super(HttpStatus.NOT_FOUND, reason);
        }
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such quote")
    // or
    // @ExceptionHandler(IndexOutOfBoundsException.class)
    @ExceptionHandler()
    public void noSuchQuote(IndexOutOfBoundsException e) {
    }

    // @ExceptionHandler
    // public ResponseEntity<?> indexOutOfBounds(IndexOutOfBoundsException e) {
    // var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    // problemDetail.setTitle("The index is out of bound");
    // problemDetail.setDetail(e.getMessage());
    // problemDetail.setType(URI.create(
    // "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/" +
    // "java/lang/IndexOutOfBoundsException.html"));
    // return ResponseEntity.of(problemDetail).build();
    // }
    // @ExceptionHandler
    // public ResponseEntity<String> indexOutOfBounds(IndexOutOfBoundsException e) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND)
    // .body(e.getMessage());
    // }

    @GetMapping
    public String retrieveQuote(int index) {
        // try {
        return quotes.quote(index);
        // } catch (Exception e) {
        // throw new QuoteNotFoundException("No such quote with index " + index);
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND,
        // "No such quote",
        // e);
        // }
    }
}