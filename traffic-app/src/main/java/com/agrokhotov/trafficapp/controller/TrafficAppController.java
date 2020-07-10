package com.agrokhotov.trafficapp.controller;

import com.agrokhotov.trafficapp.entity.Answer;
import com.agrokhotov.trafficapp.entity.Visit;
import com.agrokhotov.trafficapp.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrafficAppController {

    private final TrafficService trafficService;

    @Autowired
    public TrafficAppController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping("/visit")
    public List<Answer> addVisitAndGetDailyTraffic(@RequestParam(name = "id") Long id,
                                                   @RequestParam(name = "page_id") Long page_id,
                                                   HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(365 * 24 * 60 * 60);
        trafficService.createVisit(new Visit(id, page_id, Date.valueOf(LocalDate.now()), session.getId()));

        List<Answer> responses = new ArrayList<>();
        responses.add(trafficService.countVisitsForToday());
        responses.add(trafficService.countUniqueVisitsForToday());

        return responses;
    }

    @GetMapping("/traffic")
    public List<Answer> periodTraffic(@RequestParam(name = "from") Date from,
                                        @RequestParam(name = "to") Date to) {
        List<Answer> responses = new ArrayList<>();
        responses.add(trafficService.countPeriodVisits(from, to));
        responses.add(trafficService.countPeriodUniqueVisits(from, to));
        responses.add(trafficService.countPeriodRegularUsers(from, to));

        return responses;
    }
}
