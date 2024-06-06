package com.tutego.date4u.core.photo;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Photo {
    public Long id;
    public Long profile;
    public String name;
    public boolean isProfilePhoto;
    public LocalDateTime created;

    public String getName() {
        return "photo";
    }

    @Bean
    public KeyGenerator photoNameKeyGenerator() {
        return (Object __, Method ___, Object... params) -> {
            if (params.length == 1 && params[0] instanceof Photo photo)
                return photo.name;
            throw new UnsupportedOperationException(
                    "Can't apply this KeyGenerator here");
        };
    }
}