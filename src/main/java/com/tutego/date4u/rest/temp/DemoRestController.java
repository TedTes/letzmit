package com.tutego.date4u.rest.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    @GetMapping("/tip")
    String shortQuote() {
        return "Die with memories, not dreams.";
    }

    @GetMapping("/stats")
    String numberOfRegisteredUnicorns() {
        return "20";
    }
}
