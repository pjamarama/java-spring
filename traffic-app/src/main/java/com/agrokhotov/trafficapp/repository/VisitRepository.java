package com.agrokhotov.trafficapp.repository;

import com.agrokhotov.trafficapp.entity.Answer;
import com.agrokhotov.trafficapp.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Long countAllByDateBetweenAndDistinctSession(Date from, Date to);

    Long countAllByDateBetween(Date from, Date to);

    Long countAllByDateAndDistinctSession(Date valueOf);

    Long countAllByDate(Date valueOf);

    Long countAllRegularUsers(Date from, Date to);
}
