package com.tutego.date4u.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import jakarta.validation.constraints.*;

public record ProfileDto(
        @Min(1) Long id, @NonNull @Length(min = 10, max = 200) String nickname, @Past LocalDate birthdate,
        @Positive int manelength,
        @Min(1) int gender, @Min(1) Byte attractedToGender, String description,
        @Past LocalDateTime lastseen) {
}
