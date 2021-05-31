package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.Employee;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator extends UserValidator implements EmployeeValidatorService{
    @Override
    public Result isEmployeeNullCheck(Employee employee) {
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        if(!super.userNullCheck(employee).isSuccess()|| Strings.isNullOrEmpty(firstName)||Strings.isNullOrEmpty(lastName)){
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
