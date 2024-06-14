package com.tutego.date4u.core.photo.profile;

import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;

@Entity
@Access(AccessType.FIELD)
public class Unicorn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "profile_fk")
    private Profile profile;

    public Unicorn() {
    }
    // Setter/Getter
}