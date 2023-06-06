package com.fsd.donormicroservices.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fsd.donormicroservices.payload.Project;
import com.fsd.donormicroservices.service.DonorService;
import com.fsd.donormicroservices.entity.Donor;
import com.fsd.donormicroservices.payload.DonorDto;
import com.fsd.donormicroservices.entity.Donor;

import com.fsd.donormicroservices.payload.DonorDto;

@RunWith(SpringRunner.class)
@WebMvcTest(DonorController.class)
public class DonorControllerTest {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private DonorService dservice;
	@Test
	public void createDonor() throws Exception {
		    
		    Project project =new Project();
		    project.setId(1L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
		    
		    Donor donor =new Donor();
		 donor.setId(1L);
		    donor.setDonor_name("subbu");
		    donor.setDonor_email("subbu6548@gmail.com");
		    donor.setDonor_project_code(101L);
		    donor.setDonor_phno(93982828L);
		    donor.setDonation(234L);
		    donor.setType("visa");
		    donor.setCardn(84839289L);
		    donor.setExp("4/3/23");
		    donor.setCvv(422L);
		    DonorDto donorDto = new DonorDto();
		    donorDto.setId(donor.getId());
		    donorDto.setDonorname(donor.getDonor_name());
	 
	     	donorDto.setDonoremail(donor.getDonor_email());
	     	donorDto.setDonordonation(donor.getDonation());
	     	
		
		    donorDto.setProjectCode(project.getProjectCode());
		    donorDto.setProject_name(project.getProject_name());
		    donorDto.setProject_description(project.getProject_desc());
		    donorDto.setProjectplace(project.getProjectplace());
		
		    
		when(dservice.saveDonor(donor)).thenReturn(donorDto);
		
	}

	
	@Test
	public void getDonors() throws Exception
	{

		
		
		Donor donor =new Donor();
		donor.setId(1L);
	    donor.setDonor_name("subbu");
	    donor.setDonor_email("subbu6548@gmail.com");
	    donor.setDonor_project_code(101L);
	    donor.setDonor_phno(93982828L);
	    donor.setDonation(234L);
	    donor.setType("visa");
	    donor.setCardn(84839289L);
	    donor.setExp("4/3/23");
	    donor.setCvv(422L);
	   
	    Donor donor1 =new Donor();
		donor1.setId(2L);
	    donor1.setDonor_name("karthik");
	    donor1.setDonor_email("karthik6548@gmail.com");
	    donor1.setDonor_project_code(102L);
	    donor1.setDonor_phno(9367328L);
	    donor.setDonation(543L);
	    donor.setType("rupay");
	    donor.setCardn(84854389L);
	    donor.setExp("4/3/23");
	    donor.setCvv(432L);
	    
	    
	    
	    List<Donor> donors=new ArrayList<Donor>();
	    donors.add(donor);
	    donors.add(donor1);
	  	when(dservice.getAllDonors()).thenReturn(donors);

	  	mvc.perform(get("/api/donor").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	  	.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
		
		
	}
	@Test 
	public void getDonorBy() throws Exception{
		
		Donor donor =new Donor();
		donor.setId(1L);
	    donor.setDonor_name("subbu");
	    donor.setDonor_email("subbu6548@gmail.com");
	    donor.setDonor_project_code(101L);
	    donor.setDonor_phno(93982828L);
	    donor.setDonation(234L);
	    donor.setType("visa");
	    donor.setCardn(84839289L);
	    donor.setExp("4/3/23");
	    donor.setCvv(422L);
	    Project project =new Project();
	    project.setId(1L);
	    project.setProject_name("wearetheir");
	    project.setProject_desc("we are there for you");
	    project.setProjectCode(101L);
	    project.setProjectplace("nellore");
	    project.setProjectdate("3-5-23");
	    DonorDto donorDto = new DonorDto();
	    donorDto.setId(donor.getId());
	    donorDto.setDonorname(donor.getDonor_name());
     	donorDto.setDonoremail(donor.getDonor_email());
     	donorDto.setDonordonation(donor.getDonation());
	    donorDto.setProjectCode(project.getProjectCode());
	    donorDto.setProject_name(project.getProject_name());
	    donorDto.setProject_description(project.getProject_desc());
	    donorDto.setProjectplace(project.getProjectplace());
	
	    
		when(dservice.getDonorById(101L)).thenReturn(donorDto);
		
	}
	
	
}
