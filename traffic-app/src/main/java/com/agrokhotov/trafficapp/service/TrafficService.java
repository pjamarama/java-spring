package com.agrokhotov.trafficapp.service;

import com.agrokhotov.trafficapp.entity.Answer;
import com.agrokhotov.trafficapp.entity.Visit;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * Common interface for traffic service
 */
@Service
public interface TrafficService {

    void createVisit(Visit visit);

    Answer countVisitsForToday();

    Answer countUniqueVisitsForToday();

    Answer countPeriodVisits(Date from, Date to);

    Answer countPeriodUniqueVisits(Date from, Date to);

    Answer countPeriodRegularUsers(Date from, Date to);
}
