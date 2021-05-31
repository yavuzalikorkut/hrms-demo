package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeValidatorService {
    public Result isEmployeeNullCheck(Employee employee);
}