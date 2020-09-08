package com.hrms.hroperatiion.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hroperatiion.entity.History;
import com.hrms.hroperatiion.entity.Resume;
import com.hrms.hroperatiion.repository.ResumeRepository;
import com.hrms.hroperatiion.service.ResumeService;
@Service
public class ResumeServiceImpl implements ResumeService {

	final static String PATTERN = "MM/dd/yyyy HH:mm:ss";
	final static DateFormat df = new SimpleDateFormat(PATTERN);
	@Autowired
	private ResumeRepository repository;

	@Override
	public void save(Resume resume) {
		resume.setCurrentStatus("RECEIVED");
		resume.setUpdatedDate(df.format(new Date()));
		History history = new History();
		List<History> list = new ArrayList<>();
		list.add(history);
		resume.setHistory(list);
		repository.save(resume);
	}

	@Override
	public List<Resume> getAll() {
		return repository.findAll();
	}

	@Override
	public Resume getById(Integer id) {

		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void updateStatus(Integer id, String status, String feedback) {
		Resume resume = repository.findById(id).orElse(null);
		String updatedDate = df.format(new Date());
		resume.setCurrentStatus(status);
		resume.setUpdatedDate(updatedDate);
		History history = new History();
		history.setStatus(status);
		history.setDate(updatedDate);
		history.setFeedback(feedback);
		resume.getHistory().add(history);
		repository.save(resume);
	}

}
