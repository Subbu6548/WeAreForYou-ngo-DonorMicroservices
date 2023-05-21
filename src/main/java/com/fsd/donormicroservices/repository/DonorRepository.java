package com.fsd.donormicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fsd.donormicroservices.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor,Long> 
{

}
