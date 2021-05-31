package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.JobPost;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class JobPostValidator implements JobPostValidatorService {
    @Override
    public Result isNullCheck(JobPost jobPost) {
        String description = jobPost.getDescription();
        if (Strings.isNullOrEmpty(description)) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}