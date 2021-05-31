package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.EmployeeService;
import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.business.validationRules.EmployeeValidatorService;
import com.kodlamaio.hrms.business.validationRules.UserValidator;
import com.kodlamaio.hrms.core.utilities.business.BusinessEngine;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.core.utilities.verificationtool.CodeGenerator;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager extends UserManager<Employee> implements EmployeeService {
    private final EmployeeValidatorService employeeValidatorService;

    @Autowired
    public EmployeeManager(UserDao<Employee> userDao, EmployeeValidatorService employeeValidatorService) {
        super(userDao);
        this.employeeValidatorService = employeeValidatorService;
    }

    @Override
    public Result add(Employee employee) {
        Result result = BusinessEngine.run(employeeValidatorService.isEmployeeNullCheck(employee));
        if (!result.isSuccess()) {
            return result;
        }
        employee.setUid(CodeGenerator.generateUuidCode());
        super.add(employee);
        return new SuccessResult(Messages.EmployeeAdded);
    }

}
