package com.kodlamaio.hrms.business.abstracts.auth;


import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;


public interface EmployerAuthService extends UserAuthService<RegisterForEmployerDto, Employer> {
}