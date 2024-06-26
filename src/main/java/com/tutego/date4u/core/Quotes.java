package com.tutego.date4u.core;

import org.springframework.stereotype.Service;

@Service
public class Quotes {
    private final static String[] QUOTES = {
            "Date to be known, not to be liked",
            "Dating is all about the chase. It’s fun!",
            "You can’t blame gravity for falling in love"
    };

    public String quote(int index) {
        return QUOTES[index];
    }
}
