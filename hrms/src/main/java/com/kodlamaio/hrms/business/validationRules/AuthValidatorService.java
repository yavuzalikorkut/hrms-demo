package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.core.utilities.results.Result;

public interface AuthValidatorService {
    Result isPasswordConfirmed(String password, String confirmPassword);
}