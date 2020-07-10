package com.agrokhotov.trafficapp.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "date")
    private Date date;

    @Column(name = "session")
    private String session;

    public Visit() {
    }

    public Visit(Long userId, Long pageId, Date date, String session) {
        this.userId = userId;
        this.pageId = pageId;
        this.date = date;
        this.session = session;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}