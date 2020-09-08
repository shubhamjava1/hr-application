package com.hrms.hroperatiion.service;

import java.util.List;

import com.hrms.hroperatiion.entity.JobPostEntity;

public interface JobPostService {

	public void saveJobPost(JobPostEntity jobPost);
	
	public List<JobPostEntity> getJobPost();
	
	public JobPostEntity getJobPostById(Integer id);
	
	public void delete(Integer id);
	
	
}
