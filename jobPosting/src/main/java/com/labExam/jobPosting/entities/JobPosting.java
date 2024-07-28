package com.labExam.jobPosting.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobPostings")
public class JobPosting {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	
	@Column(length = 20,nullable = false)
	private String jobTitle;
	
	@Column(length = 20, nullable = false)
	private String companyName;
	
	@Column(length = 20, nullable = false)
	private String location;
	
	@Column(length = 200)
	private String dsecription;
	
	@Column(length = 70)
	private String requirements;
	
	@Column(nullable = false)
	private double salary;
	
	@Column
	private LocalDate date;

	public JobPosting( String jobTitle, String companyName, String location, String dsecription,
			String requirements, double salary, LocalDate date) {
		super();
		
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.location = location;
		this.dsecription = dsecription;
		this.requirements = requirements;
		this.salary = salary;
		this.date = date;
	}
	
	
}
