package com.tutego.date4u.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tutego.date4u.core.photo.profile.Profile;

// CrudRepository<Profile, Long>
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
