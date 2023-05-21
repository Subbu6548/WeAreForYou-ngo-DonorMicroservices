package com.fsd.donormicroservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.donormicroservices.entity.Donor;
import com.fsd.donormicroservices.payload.DonorDto;
import com.fsd.donormicroservices.payload.Project;


@Service
public interface DonorService {
	public  DonorDto saveDonor(Donor donor);
	public DonorDto getDonorById(long id);
	/*public Donor saveDonations(Donor donor); */
	 public List<Donor> getAllDonors(); 
	
   
}
