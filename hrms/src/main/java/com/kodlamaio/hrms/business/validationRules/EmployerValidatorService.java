package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {
	 Result employerNullCheck(Employer employer);
	 Result isEmailDomainCheck(Employer employer);
}
