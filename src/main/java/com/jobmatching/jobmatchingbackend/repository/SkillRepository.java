package com.jobmatching.jobmatchingbackend.repository;

import com.jobmatching.jobmatchingbackend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
