package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.kodlamaio.hrms.entities.abstracts.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@Table(name="employers")
public class Employer extends User{

	 public Employer( String companyName,String webAdress,String phoneNumber,String email,String password){
	        super(email,password);
	        this.companyName=companyName;
	        this.webAddress=webAdress;
	        this.phoneNumber=phoneNumber;
	    }
	 
	    @Column(name="company_name")
	    private String companyName;

	    @Column(name="web_address")
	    private String webAddress;

	    @Column(name="phone_number")
	    private String phoneNumber;
}
