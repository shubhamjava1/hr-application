package com.hrms.hroperatiion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hroperatiion.entity.Resume;
import com.hrms.hroperatiion.service.ResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {
	
	@Autowired
	private ResumeService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@Valid @RequestBody Resume entity) {
	
		service.save(entity);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Resume> getJobList() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Resume getJobPostById(@PathVariable("id") Integer id) {
		return service.getById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateStatus(@RequestParam("id") Integer id,@RequestParam("status") String status,@RequestParam("feedback") String feedback) {
		service.updateStatus(id, status, feedback);
	}
}
