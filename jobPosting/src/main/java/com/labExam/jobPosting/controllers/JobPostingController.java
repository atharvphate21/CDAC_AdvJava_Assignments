package com.labExam.jobPosting.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labExam.jobPosting.dtos.JobPostingDto;
import com.labExam.jobPosting.services.JobPostingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobPostings")
public class JobPostingController {
	
	@Autowired
	private JobPostingService jobPostingService;
//	create
	
	@PostMapping
	public ResponseEntity<JobPostingDto> createJob(@Valid @RequestBody JobPostingDto jobPostingDto){
		
		JobPostingDto newJobDto = 	jobPostingService.createNewJob(jobPostingDto);
		
		return new ResponseEntity<>(newJobDto, HttpStatus.CREATED);
		
	}
//	update
	
	@PutMapping("/{jobId}")
    public ResponseEntity<JobPostingDto> updateUser(
            @PathVariable("jobId") int jobId,
            @Valid @RequestBody JobPostingDto jobPostingDto
    ) {
		JobPostingDto updatedUserDto = jobPostingService.updateJob(jobPostingDto, jobId);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }
//	delete
	@DeleteMapping("/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable int jobId){
		jobPostingService.deleteJob(jobId);
		return new ResponseEntity<>("Job Post deleted Successfully", HttpStatus.OK);
	}
//	getAll
	@GetMapping
	public ResponseEntity<List<JobPostingDto>> getAllUsers(){
		return new ResponseEntity<>(jobPostingService.getAllJob(), HttpStatus.OK);
	}
	
//	getSingle
	@GetMapping("/{jobId}")
	public ResponseEntity<JobPostingDto> getSingleJob(@PathVariable int jobId){
		
		return new ResponseEntity<>(jobPostingService.getSingleJob(jobId), HttpStatus.OK);
				
	}
	

}
