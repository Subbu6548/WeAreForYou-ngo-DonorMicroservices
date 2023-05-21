package com.fsd.donormicroservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.donormicroservices.entity.Donor;
import com.fsd.donormicroservices.payload.DonorDto;
import com.fsd.donormicroservices.service.DonorService;


@RestController
@RequestMapping("/api/donor")
public class DonorController {
	@Autowired
	private DonorService donorService;
	
	
	/*@PostMapping
	public Donor createDonors(@RequestBody Donor donor)
	{
		return donorService.saveDonations(donor);
	}
	*/
	
	@CrossOrigin(origins = {"http://localhost:3000"})
	@PostMapping
	public DonorDto createDonor(@RequestBody Donor donor)
	{
		return donorService.saveDonor(donor);
	}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("/{id}")
	public DonorDto getDonorBy(@PathVariable("id") long id)
	{
		return donorService.getDonorById(id);
	}
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping
	private List<Donor> getdonors() 
	{
	return donorService.getAllDonors();
	}

}
