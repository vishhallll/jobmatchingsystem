package com.jobmatching.jobmatchingbackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="job")
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;


    String title;
    String description;
    String location;
    String company;
    String salary;

    @ElementCollection
    @CollectionTable(name = "job_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "skill")
    private List<String> skills;


    public Job() {

    }

    public Job(String title, String description, String location, String company, String salary, List<String> skills) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.salary = salary;
        this.skills = skills;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    public void setJob_id(Long id) {
        job_id=id;
    }
}
