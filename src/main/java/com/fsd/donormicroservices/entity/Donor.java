package com.fsd.donormicroservices.entity;


import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="donor", uniqueConstraints={
        @UniqueConstraint(columnNames= {"donor_phno"})
 })
public class Donor {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long id;
     
    @Column (nullable = false)
    private String donor_name;
    
    @Column (nullable = false)
    private String donor_email;
    
    @Column (nullable = false)
    private long donor_project_code ;
    
    @Column (nullable = false)
    private long donor_phno ;
    
    @Column (nullable = false)
    private long donation;
    
	private String type;
	
	@Column(name = "cardn",nullable = false)
	private long cardn;
	
	@Column (nullable = false)
	private String exp;
	
	@Column(nullable = false)
	private long cvv;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public String getDonor_email() {
		return donor_email;
	}
	public void setDonor_email(String donor_email) {
		this.donor_email = donor_email;
	}
	public long getDonor_project_code() {
		return donor_project_code;
	}
	public void setDonor_project_code(long donor_project_code) {
		this.donor_project_code = donor_project_code;
	}
	public long getDonor_phno() {
		return donor_phno;
	}
	public void setDonor_phno(long donor_phno) {
		this.donor_phno = donor_phno;
	}
	public long getDonation() {
		return donation;
	}
	public void setDonation(long donation) {
		this.donation = donation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getCardn() {
		return cardn;
	}
	public void setCardn(long cardn) {
		this.cardn = cardn;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public long getCvv() {
		return cvv;
	}
	public void setCvv(long cvv) {
		this.cvv = cvv;
	}
	public Donor(long id, String donor_name, String donor_email, long donor_project_code, long donor_phno,
			long donation, String type, long cardn, String exp, long cvv) {
		super();
		this.id = id;
		this.donor_name = donor_name;
		this.donor_email = donor_email;
		this.donor_project_code = donor_project_code;
		this.donor_phno = donor_phno;
		this.donation = donation;
		this.type = type;
		this.cardn = cardn;
		this.exp = exp;
		this.cvv = cvv;
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Donor [id=" + id + ", donor_name=" + donor_name + ", donor_email=" + donor_email
				+ ", donor_project_code=" + donor_project_code + ", donor_phno=" + donor_phno + ", donation=" + donation
				+ ", type=" + type + ", cardn=" + cardn + ", exp=" + exp + ", cvv=" + cvv + "]";
	}
	
    
}
