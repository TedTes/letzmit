package com.tutego.date4u.shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class PromptProviderConfig {
    private static final PromptProvider userPromptProvider = () -> new AttributedString("date4u:>");
    private static final PromptProvider adminPromptProvider = () -> new AttributedString("date4u[admin]:>",
            AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));

    // @Bean
    // PromptProvider customPromptProvider() {
    // // if ( is admin )
    // // return adminPromptProvider;
    // // else
    // // return userPromptProvider;
    // return adminPromptProvider;
    // }
}
