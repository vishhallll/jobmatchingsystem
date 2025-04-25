package com.jobmatching.jobmatchingbackend.service;

import com.jobmatching.jobmatchingbackend.model.Application;
import com.jobmatching.jobmatchingbackend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long applicationId) {
        return applicationRepository.findById(applicationId);
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
