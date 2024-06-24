package com.tutego.date4u.core.photo;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.AccessType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import com.tutego.date4u.core.photo.profile.*;

@Entity
@Access(AccessType.FIELD)
@Configuration
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // @Min(1)
    @ManyToOne
    @JoinColumn(name = "profile_fk")
    private Profile profile;
    @NotNull
    @Pattern(regexp = "[\\w_-]{1,200}")
    public String name;
    public boolean isProfilePhoto;
    @NotNull
    @Past
    public LocalDateTime created;

    public Photo() {
    }

    public Photo(Long id, Profile profile, String name, boolean isProfilePhoto, LocalDateTime created) {
        this.id = id;
        this.profile = profile;
        this.name = name;
        this.isProfilePhoto = isProfilePhoto;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProfilePhoto() {
        return isProfilePhoto;
    }

    public void setProfilePhoto(boolean profilePhoto) {
        isProfilePhoto = profilePhoto;
    }

    public void setProfile(Profile profile) {
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Photo[" + id + "]";
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