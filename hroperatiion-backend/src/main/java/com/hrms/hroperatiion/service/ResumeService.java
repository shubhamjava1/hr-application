package com.hrms.hroperatiion.service;

import java.util.List;

import com.hrms.hroperatiion.entity.Resume;

public interface ResumeService {
	
	public void save(Resume resume);

	public List<Resume> getAll();

	public Resume getById(Integer id);

	public void delete(Integer id);

	public void updateStatus(Integer id, String status, String feedback);
}
