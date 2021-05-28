package com.kodlamaio.hrms.business.validationRules;

import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;

@Component
public class CandidateValidator extends UserValidator implements CandidateValidatorService {
    public Result candidateNullCheck(Candidate candidate) {
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        String tc = candidate.getNationalIdentity();
        Date birth = candidate.getDateOfBirth();


        if (super.userNullCheck(candidate).isSuccess() && (firstName == null || firstName.isBlank()) &&
                (lastName == null || lastName.isBlank()) && (tc == null || tc.isBlank()) && birth == null) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }

    @Override
    public Result nationalIdValid(String nationalIdentity) {
        if(nationalIdentity.length()==11){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.nationalIdentityInvalid);
    }
}