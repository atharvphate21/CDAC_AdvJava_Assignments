package com.labExam.jobPosting.services;

import java.util.List;

import com.labExam.jobPosting.dtos.JobPostingDto;

public interface JobPostingService {

	
//	Post new job
	JobPostingDto createNewJob(JobPostingDto jobPostingDto);
	
//	update job details
	JobPostingDto updateJob(JobPostingDto jobPostingDto, int jobId);
	
//	delete job post
	void deleteJob(int jobId);
	
//	get all job postings
	List<JobPostingDto> getAllJob();
	
//	get single job by Id
	JobPostingDto getSingleJob(int jobId);
	
}
