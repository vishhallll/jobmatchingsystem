package com.jobmatching.jobmatchingbackend.controller;

import com.jobmatching.jobmatchingbackend.model.Job;
import com.jobmatching.jobmatchingbackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // List all jobs
    @GetMapping
    public String getAllJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "job/list"; // Thymeleaf view name
    }

    // Create new job
    @GetMapping("/create")
    public String createJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "job/create"; // Thymeleaf view name
    }

    // Save new job
    @PostMapping
    public String createJob(@ModelAttribute Job job) {
        jobService.saveJob(job);
        return "redirect:/jobs";
    }

    // Edit job
    @GetMapping("/{id}")
    public String editJob(@PathVariable("id") Long id, Model model) {
        Job job = jobService.getJobById(id).orElseThrow(() -> new IllegalArgumentException("Invalid job ID"));
        model.addAttribute("job", job);
        return "job/edit"; // Thymeleaf view name
    }

    // Update job
    @PostMapping("/{id}")
    public String updateJob(@PathVariable("id") Long id, @ModelAttribute Job job) {
        job.setJob_id(id);
        jobService.saveJob(job);
        return "redirect:/jobs";
    }

    // Delete job
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable("id") Long id) {
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }
}
