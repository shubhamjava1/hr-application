package com.hrms.hroperatiion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hroperatiion.entity.JobPostEntity;
import com.hrms.hroperatiion.repository.JobPostRepository;
import com.hrms.hroperatiion.service.JobPostService;

@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	private JobPostRepository repository;

	@Override
	public void saveJobPost(JobPostEntity jobPost) {
		repository.save(jobPost);

	}

	@Override
	public List<JobPostEntity> getJobPost() {

		return repository.findAll();
	}

	@Override
	public JobPostEntity getJobPostById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);

	}

}
