package com.hrms.hroperatiion.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobPost {
	private int id;
	private String jobTitle;
	private String description;
	private String  wageRange;
}
