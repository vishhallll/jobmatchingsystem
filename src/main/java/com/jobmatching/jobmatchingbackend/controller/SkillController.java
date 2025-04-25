package com.jobmatching.jobmatchingbackend.controller;

import com.jobmatching.jobmatchingbackend.model.Skill;
import com.jobmatching.jobmatchingbackend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    // List all skills
    @GetMapping
    public String getAllSkills(Model model) {
        model.addAttribute("skills", skillService.getAllSkills());
        return "skill/list"; // Thymeleaf view name
    }

    // Create new skill
    @GetMapping("/create")
    public String createSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "skill/create"; // Thymeleaf view name
    }

    // Save new skill
    @PostMapping
    public String createSkill(@ModelAttribute Skill skill) {
        skillService.saveSkill(skill);
        return "redirect:/skills";
    }

    // Edit skill
    @GetMapping("/{id}")
    public String editSkill(@PathVariable("id") Long id, Model model) {
        Skill skill = skillService.getSkillById(id).orElseThrow(() -> new IllegalArgumentException("Invalid skill ID"));
        model.addAttribute("skill", skill);
        return "skill/edit"; // Thymeleaf view name
    }

    // Update skill
    @PostMapping("/{id}")
    public String updateSkill(@PathVariable("id") Long id, @ModelAttribute Skill skill) {
        skill.setSkill_id(id);
        skillService.saveSkill(skill);
        return "redirect:/skills";
    }

    // Delete skill
    @GetMapping("/delete/{id}")
    public String deleteSkill(@PathVariable("id") Long id) {
        skillService.deleteSkill(id);
        return "redirect:/skills";
    }
}
