package com.agrokhotov.trafficapp.repository;

import com.agrokhotov.trafficapp.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Long countAllByDate(Date valueOf);

    Long countAllByDateBetween(Date from, Date to);

    @Query(value = "SELECT count(DISTINCT session) FROM visits WHERE (visits.date = ?1 AND ?2)", nativeQuery = true)
    Long countAllByDateBetweenAndDistinctSession(Date from, Date to);

    @Query(value = "SELECT count(DISTINCT session) FROM visits WHERE visits.date = ?1", nativeQuery = true)
    Long countAllByDateAndDistinctSession(Date valueOf);

    @Query(value = "SELECT count(DISTINCT user_id) from visits WHERE (visits.date BETWEEN ?1 AND ?2) " +
            "GROUP BY user_id HAVING count(page_id) >= 10", nativeQuery = true)
    Long countAllRegularUsers(Date from, Date to);
}
