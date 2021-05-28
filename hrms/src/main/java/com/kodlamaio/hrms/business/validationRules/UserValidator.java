package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.abstracts.User;

public class UserValidator implements UserValidatorService {

    public Result userNullCheck(User user) {
        if ((user.getEmail() == null || user.getEmail().isBlank()) && (user.getPassword() == null || user.getPassword().isBlank())) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}