package com.labExam.jobPosting.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labExam.jobPosting.dtos.JobPostingDto;
import com.labExam.jobPosting.entities.JobPosting;
import com.labExam.jobPosting.exceptions.ResourceNotFoundException;
import com.labExam.jobPosting.repositories.JobPostingRepository;
import com.labExam.jobPosting.services.JobPostingService;

@Service
public class JobPostingServiceImpl implements JobPostingService {
	
	@Autowired
	private JobPostingRepository jobPostingRepository;
	
	@Autowired
	private ModelMapper mapper;
//	Post new job
	@Override
	public JobPostingDto createNewJob(JobPostingDto jobPostingDto) {
		
		JobPosting jobPosting = mapper.map(jobPostingDto, JobPosting.class);
		JobPosting saveJob = jobPostingRepository.save(jobPosting);
//		saveJob.setDate(LocalDate.now());
        return mapper.map(saveJob, JobPostingDto.class);
	}
//	update job details
	@Override
	public JobPostingDto updateJob(JobPostingDto jobPostingDto, int jobId) {
		JobPosting jobPosting = jobPostingRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given Id !!"));
		jobPosting.setJobTitle(jobPostingDto.getJobTitle());
		jobPosting.setCompanyName(jobPostingDto.getCompanyName());
		jobPosting.setLocation(jobPostingDto.getLocation());
		jobPosting.setDsecription(jobPostingDto.getDsecription());
		jobPosting.setRequirements(jobPostingDto.getRequirements());
		jobPosting.setSalary(jobPostingDto.getSalary());
		jobPosting.setDate(jobPostingDto.getDate());
		JobPosting updatedJob = jobPostingRepository.save(jobPosting);
        return mapper.map(updatedJob, JobPostingDto.class);
		
	}
//	delete job post
	@Override
	public void deleteJob(int jobId) {
		JobPosting product = jobPostingRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given Id !!"));
		jobPostingRepository.delete(product);
		
	}
//	get all job postings
	@Override
	public List<JobPostingDto> getAllJob() {
//		List<JobPosting> jobPostings = jobPostingRepository.findAll();
		
		return jobPostingRepository.findAll().stream()
                .map(job -> mapper.map(job, JobPostingDto.class))
                .collect(Collectors.toList());
	}
//	get single job by Id
	@Override
	public JobPostingDto getSingleJob(int jobId) {
		JobPosting jobPosting = jobPostingRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given Id !!"));
	        return mapper.map(jobPosting, JobPostingDto.class);
	}

}
