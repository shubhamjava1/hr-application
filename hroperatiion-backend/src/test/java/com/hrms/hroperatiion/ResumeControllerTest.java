package com.hrms.hroperatiion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hrms.hroperatiion.entity.JobPostEntity;
import com.hrms.hroperatiion.entity.Resume;

public class ResumeControllerTest  extends AbstractHroperatiionApplicationTests {
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createProfile() throws Exception {
		String uri = "/resume";
		JobPostEntity job = new JobPostEntity();
		job.setId(1);
		job.setJobTitle("java developer");
		Resume profile = new Resume();
		profile.setId(1);
		profile.setNameOfCandiate("Shubham");
		profile.setVendorCompany("Emonics");
		profile.setVendorRepEmail("feroz@emonics.com");
		profile.setVendorRepName("Feroz Sayyed");
		profile.setJobPost(job);
		String inputJson = super.mapToJson(profile);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Profile is submitted successfully");
	}
	
	@Test
	public void getProfileList() throws Exception {
		String uri = "/resume";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		JobPostEntity[] productlist = super.mapFromJson(content, JobPostEntity[].class);
		assertTrue(productlist.length > 0);
	}

	
	@Test
	public void deleteProduct() throws Exception {
		String uri = "/resume/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Profile is deleted successsfully");
	}
}
