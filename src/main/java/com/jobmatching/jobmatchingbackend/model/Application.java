package com.jobmatching.jobmatchingbackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long application_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private LocalDate appliedDate;
    private String status; // pending, accepted, rejected

    public Application() {
    }

    public Application(User user, Job job, LocalDate appliedDate, String status) {
        this.user = user;
        this.job = job;
        this.appliedDate = appliedDate;
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setApplication_id(Long id) {
        this.application_id = id;
    }
}
