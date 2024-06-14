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

import com.tutego.date4u.core.photo.Photo;

@Entity
@Access(AccessType.FIELD)
@Configuration
public class Profile {
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
    @OneToOne(mappedBy = "profile")
    private Unicorn unicorn;

    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
    @OrderBy("created")
    private List<Photo> photos = new ArrayList<>();

    protected Profile() {
    }

    public Profile(String nickname, LocalDate birthdate,
            int manelength, int gender,
            Integer attractedToGender, String description,
            LocalDateTime lastseen) {
        setNickname(nickname);
        setBirthdate(birthdate);
        setManelength(manelength);
        setGender(gender);
        setAttractedToGender(attractedToGender);
        setDescription(description);
        setLastseen(lastseen);
    }

    private void setLastseen(LocalDateTime lastseen2) {
        this.lastseen = lastseen2;
        throw new UnsupportedOperationException("Unimplemented method 'setLastseen'");
    }

    private void setDescription(String description2) {
        this.description = description2;
        throw new UnsupportedOperationException("Unimplemented method 'setDescription'");
    }

    public void setAttractedToGender(@Nullable Integer attractedToGender) {
        this.attractedToGender = attractedToGender == null ? null : attractedToGender.byteValue();
    }

    private void setGender(int gender2) {
        this.gender = (byte) gender2;
        throw new UnsupportedOperationException("Unimplemented method 'setGender'");
    }

    public void setManelength(int manelength2) {
        this.manelength = (short) manelength2;
        throw new UnsupportedOperationException("Unimplemented method 'setManelength'");
    }

    private void setBirthdate(LocalDate birthdate2) {
        this.birthdate = birthdate2;
        throw new UnsupportedOperationException("Unimplemented method 'setBirthdate'");
    }

    private void setNickname(String nickname2) {
        this.nickname = nickname2;
        throw new UnsupportedOperationException("Unimplemented method 'setNickname'");
    }

    public String getNickname() {
        return this.nickname;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getNickname'");
    }

    public short getManelength() {
        return this.manelength;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getManelength'");
    }

    public Long getId() {
        return this.id;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getNickname'");
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getManelength'");
    }

    public Unicorn getUnicorn() {
        return new Unicorn();
    }

    // public Profile add(Photo photo) {
    // photos.add(photo);
    // return this;
    // }

    public void setUnicorn(Unicorn unicorn) {
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
