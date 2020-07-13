package com.agrokhotov.trafficapp.service;

import com.agrokhotov.trafficapp.entity.Answer;
import com.agrokhotov.trafficapp.entity.Visit;
import com.agrokhotov.trafficapp.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Implementation of TrafficService interface
 */
@Service
public class TrafficServiceImpl implements TrafficService {

    private final VisitRepository visitRepository;

    @Autowired
    public TrafficServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public void createVisit(Visit visit) {
        visitRepository.save(visit);
    }

    @Override
    public Answer countVisitsForToday() {
        return new Answer("Visits for today", visitRepository.countAllByDate(Date.valueOf(LocalDate.now())));
    }

    @Override
    public Answer countUniqueVisitsForToday() {
        return new Answer("Unique visits for today",
                visitRepository.countAllByDateAndDistinctSession(Date.valueOf(LocalDate.now())));
    }

    @Override
    public Answer countVisitsForPeriod(Date from, Date to) {
        return new Answer("Visit count for the given period", visitRepository.countAllByDateBetween(from, to));
    }

    @Override
    public Answer countUniqueVisitsForPeriod(Date from, Date to) {
        return new Answer("Unique visit count for the given period",
                visitRepository.countAllByDateBetweenAndDistinctSession(from, to));
    }

    @Override
    public Answer countRegularUsersForPeriod(Date from, Date to) {
        Long count = visitRepository.countAllRegularUsers(from, to);
        if (count == null) {
            count = 0L;
        }
        return new Answer("Regular users count", count);
    }
}
