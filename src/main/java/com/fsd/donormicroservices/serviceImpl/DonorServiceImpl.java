package com.fsd.donormicroservices.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.donormicroservices.entity.Donor;
import com.fsd.donormicroservices.feignclient.ProjectFeign;
import com.fsd.donormicroservices.payload.DonorDto;
import com.fsd.donormicroservices.payload.Project;
import com.fsd.donormicroservices.repository.DonorRepository;
import com.fsd.donormicroservices.service.DonorService;
import com.google.gson.Gson;

import feign.Response;


@Service
public class DonorServiceImpl implements DonorService {	


	@Autowired
	private DonorRepository donorRepository;
    @Autowired
	private ProjectFeign projectFeign;
    
    /*@Override
   	 public Donor saveDonations(Donor donor) 
	 {
	 Donor savedDonations = donorRepository.save(donor);
	 return savedDonations;
	 }  
	 */
    

	@Override
	public DonorDto saveDonor(Donor donor) {
 
 	Donor savedDonor=donorRepository.save(donor);
	Response response = projectFeign.getProjectByCode(savedDonor.getDonor_project_code());
	DonorDto donorDto = new DonorDto();
   String body=response.body().toString();
   Gson g=new Gson();
   Project project=g.fromJson(body,Project.class);
	donorDto.setId(savedDonor.getId());
	donorDto.setDonorname(savedDonor.getDonor_name());

	donorDto.setDonoremail(savedDonor.getDonor_email());
    donorDto.setDonordonation(savedDonor.getDonation());
	
	 donorDto.setProjectCode(project.getProjectCode());
	 donorDto.setProject_name(project.getProject_name());
	 donorDto.setProject_description(project.getProject_desc());
	 donorDto.setProjectplace(project.getProjectplace());
	
	return donorDto;
}
	
	@Override
	public DonorDto getDonorById(long id) 
	{

	Donor foundDonor = donorRepository.findById(id).get();
	Response response = projectFeign.getProjectByCode(foundDonor.getDonor_project_code());
	DonorDto donorDto = new DonorDto();
     String body=response.body().toString();
   Gson g=new Gson();
   Project project=g.fromJson(body,Project.class);
	donorDto.setId(foundDonor.getId());

	donorDto.setDonorname(foundDonor.getDonor_name());

	donorDto.setDonoremail(foundDonor.getDonor_email());
	donorDto.setDonordonation(foundDonor.getDonation());
	donorDto.setProjectCode(project.getProjectCode());
     
	donorDto.setProject_name(project.getProject_name());
	donorDto.setProject_description(project.getProject_desc());
	donorDto.setProjectplace(project.getProjectplace());

	return donorDto;
	}
	
	@Override
	public List<Donor> getAllDonors() 
	{
		List<Donor> donors = new ArrayList<Donor>();
		donorRepository.findAll().forEach(donor1 -> donors.add(donor1));
        return donors;
	}

}
