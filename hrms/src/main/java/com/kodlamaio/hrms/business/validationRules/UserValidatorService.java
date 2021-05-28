package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.abstracts.User;

public interface UserValidatorService {
	Result userNullCheck(User user);
}
