package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.ActivationCode;

import java.util.List;
import java.util.Optional;

public interface ActivationCodeService {
	DataResult<List<ActivationCode>> getAll();
    Result add(ActivationCode activationCode);
    Result update(ActivationCode activationCode);
    DataResult<Optional<ActivationCode>> getByUserUid(String uid);
}
