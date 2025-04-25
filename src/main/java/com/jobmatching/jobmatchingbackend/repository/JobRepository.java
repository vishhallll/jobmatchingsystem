package com.jobmatching.jobmatchingbackend.repository;

import com.jobmatching.jobmatchingbackend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
