package com.hrms.hroperatiion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hroperatiion.entity.Resume;
@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {
	
	/*
	 * @Modifying
	 * 
	 * @Query("update Resume u set u.status = :status where u.id < :id") void
	 * update(@Param("id") Integer id, @Param("status") String status);
	 */

}
