package com.hrms.hroperatiion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hrms.hroperatiion.entity.JobPostEntity;

public class JobControllerTest extends AbstractHroperatiionApplicationTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createJob() throws Exception {
		String uri = "/job";
		JobPostEntity job = new JobPostEntity();
		job.setId(1);
		job.setJobTitle("Full Stack Java Developer");
		job.setDescription("Spring boot with microservices with angular developer");
		String inputJson = super.mapToJson(job);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Job is created successfully");
	}
	
	@Test
	public void getProductsList() throws Exception {
		String uri = "/job";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		JobPostEntity[] productlist = super.mapFromJson(content, JobPostEntity[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void updateProduct() throws Exception {
		String uri = "/job/1";
		JobPostEntity job = new JobPostEntity();
		job.setJobTitle("Full Stack Java Developer");
		job.setDescription("Spring boot with microservices with angular developer");
		String inputJson = super.mapToJson(job);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Job is updated successsfully");
	}

	@Test
	public void deleteProduct() throws Exception {
		String uri = "/job/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Job is deleted successsfully");
	}
}