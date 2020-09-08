package com.hrms.hroperatiion.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "resume")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String updatedDate;

	private String vendorCompany;

	private String vendorRepName;

	private String vendorRepEmail;

	private String nameOfCandiate;

	private String currentStatus;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_post_id")
	private JobPostEntity jobPost;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private List<History> history;
}