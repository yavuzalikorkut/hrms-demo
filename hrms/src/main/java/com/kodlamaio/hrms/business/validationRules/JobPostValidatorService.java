package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPost;

public interface JobPostValidatorService {
    public Result isNullCheck(JobPost jobPost);
}