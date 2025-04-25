package com.jobmatching.jobmatchingbackend.repository;

import com.jobmatching.jobmatchingbackend.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
