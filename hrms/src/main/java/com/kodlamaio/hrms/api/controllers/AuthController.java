package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.auth.CandidateAuthService;
import com.kodlamaio.hrms.business.abstracts.auth.EmployerAuthService;
import com.kodlamaio.hrms.business.abstracts.auth.VerifyService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import com.kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final CandidateAuthService candidateAuthService;
    private final EmployerAuthService employerAuthService;
    private final VerifyService verifyService;

    @Autowired
    public AuthController(CandidateAuthService candidateAuthService, EmployerAuthService employerAuthService, VerifyService verifyService) {
        this.candidateAuthService = candidateAuthService;
        this.employerAuthService = employerAuthService;
        this.verifyService = verifyService;
    }

    @PostMapping("/candidate/register")
    public Result registerForCandidate(@RequestBody @Valid RegisterForCandidateDto registerForCandidateDto) {
        return candidateAuthService.register(registerForCandidateDto);
    }

    @PostMapping("/employer/register")
    public Result registerForEmployer(@RequestBody @Valid RegisterForEmployerDto registerForEmployerDto) {
        return employerAuthService.register(registerForEmployerDto);
    }

    @GetMapping("/verify")
    public Result verify(@RequestParam("uid") String uid, @RequestParam("activationCode") String activationCode) {
        return verifyService.verify(uid, activationCode);
    }

    @GetMapping("/resend")
    public Result reSendEmail(String uid) {
        return employerAuthService.reSendMail(uid);
    }

}