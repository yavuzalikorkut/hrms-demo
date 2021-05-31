package com.kodlamaio.hrms.business.concretes.auth;


import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.business.abstracts.auth.EmployerAuthService;
import com.kodlamaio.hrms.business.validationRules.AuthValidatorService;
import com.kodlamaio.hrms.core.utilities.email.EmailSenderService;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;
import org.springframework.stereotype.Service;


@Service
public class EmployerAuthManager extends UserAuthManager<RegisterForEmployerDto, Employer> implements EmployerAuthService {

    public EmployerAuthManager(AuthValidatorService authValidatorService, UserService<Employer> userService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(authValidatorService, userService, activationCodeService, emailSenderService);
    }

    @Override
    public Employer newUserInstance(RegisterForEmployerDto registerForEmployerDto) {
        return new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAdress(), registerForEmployerDto.getPhoneNumber(), registerForEmployerDto.getEmail(), registerForEmployerDto.getPassword());
    }
}
