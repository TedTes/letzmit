package com.tutego.date4u.interfaces;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutego.date4u.core.photo.profile.Unicorn;

import jakarta.persistence.Tuple;

public interface UnicornRepository extends JpaRepository<Unicorn, Long> {
    @Query(value = """
            SELECT u.email , u.password
            FROM Unicorn u
            WHERE u.email = :email
            """)
    Unicorn findByEmail(String email);
}