package com.tutego.date4u.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.tutego.date4u.core.photo.profile.Profile;

// CrudRepository<Profile, Long>
//--> interface , QuerydslPredicateExecutor<Profile>
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // <T> Optional<T> findByNickname(String nickname,
    // Class<T> projection);
}
