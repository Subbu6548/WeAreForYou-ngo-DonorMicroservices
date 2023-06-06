package com.fsd.donormicroservices.serviceImpl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.donormicroservices.entity.Donor;
import com.fsd.donormicroservices.payload.DonorDto;
import com.fsd.donormicroservices.payload.Project;
import com.fsd.donormicroservices.repository.DonorRepository;

import feign.Response;


@RunWith(SpringRunner.class)
public class DonorServiceImplTest {
	
	@InjectMocks
	private DonorServiceImpl dser;
	@MockBean
	private com.fsd.donormicroservices.feignclient.ProjectFeign projectfeign;
	

	@Mock
	private DonorRepository drepo;
	
	
	@Before
	public void setUp() {
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
	    Mockito.when(drepo.save(donor)).thenReturn(donor);
	    
	    Donor donor1 =new Donor();
		donor1.setId(1L);
	    donor1.setDonor_name("karthik");
	    donor1.setDonor_email("karthik6548@gmail.com");
	    donor1.setDonor_project_code(102L);
	    donor1.setDonor_phno(9367328L);
	    donor.setDonation(234L);
	    donor.setType("rupay");
	    donor.setCardn(84833929L);
	    donor.setExp("4/3/23");
	    donor.setCvv(653L);
	    
	    List<Donor> donors=new ArrayList<Donor>();
	    donors.add(donor);
	    donors.add(donor1);
		Mockito.when(drepo.findAll()).thenReturn(donors);
			
	}
	

	@Test
	 public void saveDonor() {
		Donor donor =new Donor();
		DonorDto donorDto = new DonorDto();
		Project project =new Project();

		    project.setId(1L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
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
		    
           long i= donor.getDonor_project_code();
			
        Response response = projectfeign.getProjectByCode(i);
    	DonorDto volunteDto = new DonorDto();
        drepo.save(donor);
        donorDto.setId(donor.getId());
	    donorDto.setDonorname(donor.getDonor_name());
 
     	donorDto.setDonoremail(donor.getDonor_email());
     	donorDto.setDonordonation(donor.getDonation());
     	
	
	    donorDto.setProjectCode(project.getProjectCode());
	    donorDto.setProject_name(project.getProject_name());
	    donorDto.setProject_description(project.getProject_desc());
	    donorDto.setProjectplace(project.getProjectplace());
	
	   
		
		verify(drepo, times(1)).save(donor);
		 
	    
	}

	@Test
	public void getAllDonors() {

		List<Donor> donors = dser.getAllDonors();
		Assert.assertEquals(donors.size(), 2);
		
	}
	@Test
	  public void getDonorById()
	  {  
		   Donor donor =new Donor(); 
		   Project project= new Project();
		    project.setId(101L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
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
		    
		    drepo.save(donor);	   
		    long i= donor.getDonor_project_code();
		    Response response = projectfeign.getProjectByCode(i);
		    DonorDto donorDto = new DonorDto();
		    donorDto.setId(donor.getId());

			donorDto.setDonorname(donor.getDonor_name());

			donorDto.setDonoremail(donor.getDonor_email());
			donorDto.setDonordonation(donor.getDonation());
			donorDto.setProjectCode(project.getProjectCode());
		     
			donorDto.setProject_name(project.getProject_name());
			donorDto.setProject_description(project.getProject_desc());
			donorDto.setProjectplace(project.getProjectplace());

		    
		    Assert.assertEquals(donorDto.getProject_name(),"wearetheir");
	  }
	
}




