package com.tutego.date4u.core.photo.profile;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutego.date4u.core.photo.Photo;

@Entity
@Access(AccessType.FIELD)
@Configuration
public class Profile {
    public static final int FEE = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private LocalDate birthdate;
    private short manelength;
    private byte gender;
    @Column(name = "attracted_to_gender")
    private Byte attractedToGender;
    private String description;
    private LocalDateTime lastseen;
    // @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private Unicorn unicorn;

    // @JsonIgnore
    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
    @OrderBy("created")
    private List<Photo> photos = new ArrayList<>();

    protected Profile() {
    }

    public Profile(String nickname, LocalDate birthdate,
            int manelength, int gender,
            Byte attractedToGender, String description,
            LocalDateTime lastseen) {
        setNickname(nickname);
        setBirthdate(birthdate);
        setManelength(manelength);
        setGender(gender);
        setAttractedToGender(attractedToGender);
        setDescription(description);
        setLastseen(lastseen);
    }

    public void setLastseen(LocalDateTime lastseen2) {
        this.lastseen = lastseen2;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public void setAttractedToGender(@Nullable Byte attractedToGender) {
        this.attractedToGender = attractedToGender == null ? null : attractedToGender.byteValue();
    }

    public void setGender(int gender2) {
        this.gender = (byte) gender2;
    }

    public void setManelength(int manelength2) {
        this.manelength = (short) manelength2;
    }

    public void setBirthdate(LocalDate birthdate2) {
        this.birthdate = birthdate2;
    }

    public void setNickname(String nickname2) {
        this.nickname = nickname2;
    }

    public String getNickname() {
        return this.nickname;
    }

    public short getManelength() {
        return this.manelength;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public Unicorn getUnicorn() {
        return new Unicorn();
    }

    public void setUnicorn(Unicorn unicorn) {
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public byte getGender() {
        return gender;
    }

    public Byte getAttractedToGender() {
        return attractedToGender;
    }

    public LocalDateTime getLastseen() {

        return lastseen;
    }

    public String getDescription() {
        return description;
    }
}
