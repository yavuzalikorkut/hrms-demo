package com.kodlamaio.hrms.business.concretes.auth;

import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.business.abstracts.auth.CandidateAuthService;
import com.kodlamaio.hrms.business.validationRules.AuthValidatorService;
import com.kodlamaio.hrms.core.utilities.email.EmailSenderService;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import com.kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import org.springframework.stereotype.Service;

@Service
public class CandidateAuthManager extends UserAuthManager<RegisterForCandidateDto, Candidate> implements CandidateAuthService {


    public CandidateAuthManager(AuthValidatorService authValidatorService, UserService<Candidate> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Candidate newUserInstance(RegisterForCandidateDto registerForCandidateDto) {
        return new Candidate(registerForCandidateDto.getFirstName(), registerForCandidateDto.getLastName()
                , registerForCandidateDto.getNationalIdentity(), registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword());
    }
}