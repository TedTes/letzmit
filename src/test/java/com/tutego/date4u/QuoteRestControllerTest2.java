package com.tutego.date4u;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuoteRestControllerTest2 {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void first_quote_is_a_string() {
        webTestClient
                .get()
                .uri("/api/quotes?index=1")
                // .header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(String.class)
                .isEqualTo("Dating is all about the chase. It’s fun!");
    }
}
