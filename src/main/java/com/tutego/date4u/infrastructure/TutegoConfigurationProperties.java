package com.tutego.date4u.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("com.tutego") // prefix of the configuration
public class TutegoConfigurationProperties {
    private String homepage;
    private int numberOfSeminars;

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getNumberOfSeminars() {
        return numberOfSeminars;
    }

    public void setNumberOfSeminars(int numberOfSeminars) {
        this.numberOfSeminars = numberOfSeminars;
    }
}
