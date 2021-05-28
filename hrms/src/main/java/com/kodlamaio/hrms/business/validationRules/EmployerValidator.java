package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Component;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService{
	public Result employerNullCheck(Employer employer) {
        String companyName = employer.getCompanyName();
        String webAddress = employer.getWebAddress();
        String phoneNumber = employer.getPhoneNumber();

        if (super.userNullCheck(employer).isSuccess() && (companyName == null || companyName.isBlank())
                && (webAddress == null || webAddress.isBlank())&&(phoneNumber==null||phoneNumber.isBlank())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }


    public Result isEmailDomainCheck(Employer employer){
        String email = employer.getEmail();
        String webAddress = employer.getWebAddress();

        String domain = webAddress.split("www.")[1];
        if(domain.equals(email.split("@")[1])){
            return new SuccessResult();
        }
        return new ErrorResult("Domain geçersiz");
    }
}
