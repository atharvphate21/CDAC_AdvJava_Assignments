package com.labExam.jobPosting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labExam.jobPosting.entities.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Integer> {
                                 
}
