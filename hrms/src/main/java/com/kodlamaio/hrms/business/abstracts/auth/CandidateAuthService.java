package com.kodlamaio.hrms.business.abstracts.auth;

import com.kodlamaio.hrms.entities.concretes.Candidate;
import com.kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;

public interface CandidateAuthService extends UserAuthService<RegisterForCandidateDto, Candidate> {
}