package com.kodlamaio.hrms.business.abstracts.auth;

import com.kodlamaio.hrms.core.utilities.results.Result;

public interface VerifyService {
    Result verify(String uid, String activationCode);
}