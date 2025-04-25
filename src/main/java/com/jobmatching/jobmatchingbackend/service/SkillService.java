package com.jobmatching.jobmatchingbackend.service;

import com.jobmatching.jobmatchingbackend.model.Skill;
import com.jobmatching.jobmatchingbackend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getSkillById(Long skillId) {
        return skillRepository.findById(skillId);
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }
}
