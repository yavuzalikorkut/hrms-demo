package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.business.validationRules.EmployerValidatorService;
import com.kodlamaio.hrms.core.utilities.business.BusinessEngine;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {
    private EmployerValidatorService employerValidatorService;

    @Autowired
    public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService){
        super(userDao);
        this.employerValidatorService = employerValidatorService;
    }

    @Override
    public Result add(Employer employer) {
        Result result= BusinessEngine.run(employerValidatorService.employerNullCheck(employer),
                employerValidatorService.isEmailDomainCheck(employer));
        if(result.isSuccess()){
        return super.add(employer);
        }
        return result;
    }
}