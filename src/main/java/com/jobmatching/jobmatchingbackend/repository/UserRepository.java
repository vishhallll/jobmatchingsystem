package com.jobmatching.jobmatchingbackend.repository;

import com.jobmatching.jobmatchingbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
