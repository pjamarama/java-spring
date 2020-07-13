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

    Answer countVisitsForPeriod(Date from, Date to);

    Answer countUniqueVisitsForPeriod(Date from, Date to);

    Answer countRegularUsersForPeriod(Date from, Date to);
}
