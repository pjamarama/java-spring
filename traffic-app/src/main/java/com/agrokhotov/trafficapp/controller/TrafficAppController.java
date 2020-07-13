package com.agrokhotov.trafficapp.controller;

import com.agrokhotov.trafficapp.entity.Answer;
import com.agrokhotov.trafficapp.entity.Visit;
import com.agrokhotov.trafficapp.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrafficAppController {

    private final TrafficService trafficService;

    @Autowired
    public TrafficAppController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping("/visit")
    public List<Answer> visitAndGetDailyTraffic(@RequestParam(name = "id") Long id,
                                                @RequestParam(name = "page_id") Long page_id,
                                                HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("chp 1");
        session.setMaxInactiveInterval(60 * 60 * 24 * 365);
        trafficService.createVisit(new Visit(id, page_id, Date.valueOf(LocalDate.now()), session.getId()));
        System.out.println("chp 2");
        List<Answer> answers = new ArrayList<>();
        answers.add(trafficService.countVisitsForToday());
        System.out.println("chp 3");
        answers.add(trafficService.countUniqueVisitsForToday());
        System.out.println("chp 4");
        return answers;
    }

    @GetMapping("/traffic")
    public List<Answer> getTrafficForPeriod(@RequestParam(name = "from") Date from,
                                            @RequestParam(name = "to") Date to) {
        List<Answer> answers = new ArrayList<>();
        answers.add(trafficService.countVisitsForPeriod(from, to));
        answers.add(trafficService.countUniqueVisitsForPeriod(from, to));
        answers.add(trafficService.countRegularUsersForPeriod(from, to));
        return answers;
    }
}
