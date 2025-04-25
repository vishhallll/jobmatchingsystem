package com.jobmatching.jobmatchingbackend.controller;

import com.jobmatching.jobmatchingbackend.model.Application;
import com.jobmatching.jobmatchingbackend.model.User;
import com.jobmatching.jobmatchingbackend.model.Job;
import com.jobmatching.jobmatchingbackend.service.ApplicationService;
import com.jobmatching.jobmatchingbackend.service.UserService;
import com.jobmatching.jobmatchingbackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

   

    // List all applications
    @GetMapping
    public String getAllApplications(Model model) {
        model.addAttribute("applications", applicationService.getAllApplications());
        return "application/list"; // Thymeleaf view name
    }

    // Create new application
    @GetMapping("/create")
    public String createApplicationForm(Model model) {
        model.addAttribute("application", new Application());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("jobs", jobService.getAllJobs());
        return "application/create"; // Thymeleaf view name
    }

    // Save new application
    @PostMapping
    public String createApplication(@ModelAttribute Application application) {
        applicationService.saveApplication(application);
        return "redirect:/applications";
    }

    // Edit application
    @GetMapping("/{id}")
    public String editApplication(@PathVariable("id") Long id, Model model) {
        Application application = applicationService.getApplicationById(id).orElseThrow(() -> new IllegalArgumentException("Invalid application ID"));
        model.addAttribute("application", application);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("jobs", jobService.getAllJobs());
        return "application/edit"; // Thymeleaf view name
    }

    // Update application
    @PostMapping("/{id}")
    public String updateApplication(@PathVariable("id") Long id, @ModelAttribute Application application) {
        application.setApplication_id(id);
        applicationService.saveApplication(application);
        return "redirect:/applications";
    }
}

// Delete application
