package com.labExam.jobPosting.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPostingDto {

	private String jobId;
	
	@NotBlank
	@Size(min=5, max=15, message="invalid Title")
	private String jobTitle;
	
	@NotBlank
	@Size(min=5, max=15, message="invalid Company Name")
	private String companyName;
	
	@NotBlank
	@Size(min=1, max=15, message="invalid location")
	private String location;
	
	@NotBlank
	@Size(min=1, max=15, message="invalid desc")
	private String dsecription;
	
	@NotBlank
	@Size(min=1, max=15, message="invalid requirements")
	private String requirements;
	
	@NotBlank
	@Size(min=5, max=8, message="invalid salary")
	private double salary;

	private LocalDate date;
}

//validations annotations
//@Email(message="")
//@NotBlank(message="")
//@Pattern

//@Valid - to enable validation
