package com.hrms.hroperatiion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hroperatiion.entity.JobPostEntity;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Integer> {

}
