package com.tutego.date4u.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutego.date4u.interfaces.ProfileRepository;

@RequestMapping("/api")
@RestController
public class StatisticRestController {
    private final ProfileRepository profiles;

    public StatisticRestController(ProfileRepository profiles) {
        this.profiles = profiles;
    }

    // @RequestMapping(path = "/api/stat/total", method = { RequestMethod.GET })
    @GetMapping("/stat/total")
    public String totalNumberOfRegisteredUnicorns() {
        return String.valueOf(profiles.count());
    }
}