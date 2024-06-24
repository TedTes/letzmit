package com.tutego.date4u.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.tutego.date4u.core.photo.profile.Profile;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Tuple;

// CrudRepository<Profile, Long>
//--> interface , QuerydslPredicateExecutor<Profile>
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // <T> Optional<T> findByNickname(String nickname,
    // Class<T> projection);
    @Query(value = """
            SELECT YEAR(p.lastseen) AS y, MONTH(p.lastseen) AS m, COUNT(*) AS count
            FROM Profile p
            WHERE p.lastseen > :startDate AND p.lastseen < :endDate
            GROUP BY YEAR(p.lastseen), MONTH(p.lastseen)
            """)
    List<Tuple> findMonthlyProfileCount(LocalDateTime startDate,
            LocalDateTime endDate);
}
