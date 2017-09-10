package com.paris.backend.repository;

import com.paris.backend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jobRepository")
public interface JobRepository extends JpaRepository<Job, Integer> {

}
