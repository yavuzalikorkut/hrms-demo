package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateValidatorService {
    Result candidateNullCheck(Candidate candidate);
    Result nationalIdValid (String nationalIdentity);
}