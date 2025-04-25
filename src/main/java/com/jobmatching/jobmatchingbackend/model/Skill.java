package com.jobmatching.jobmatchingbackend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long skill_id;

    private String skill_name;

    @ManyToMany
    private Set<User> users;

    public Skill() {
    }

    public Skill(String skill_name, Set<User> users) {
        this.skill_name = skill_name;
        this.users = users;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setSkill_id(Long id) {
        this.skill_id = id;
    }
}
