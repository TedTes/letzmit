package com.tutego.date4u.rest.temp;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tutego.date4u.interfaces.UnicornRepository;

@Configuration(proxyBeanMethods = false)
public class UserDetailsServiceConfig {
    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return switch (username) {
                    case "fillmore.fat@wyman.co" ->
                        User.withUsername(username)
                                .password("{noop}u87szdzwr6j")
                                .roles()
                                .build();
                    case "candy.kane@mills.info" ->
                        new User(username, "{noop}mk8suwi4kq",
                                Collections.emptyList());
                    default -> throw new UsernameNotFoundException(username);
                };
            }
        };

        // @Bean
        // UserDetailsService userDetailsService(UnicornRepository unicorns) {
        // return email -> unicorns.findByEmail(email)
        // .map(unicorn -> User.withUsername(unicorn.getEmail())
        // .password(unicorn.getPassword())
        // .roles("USER").build())
        // .orElseThrow(() -> new UsernameNotFoundException(email));
        // }
    }
}
