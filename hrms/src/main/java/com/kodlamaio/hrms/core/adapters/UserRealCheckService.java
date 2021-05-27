package com.kodlamaio.hrms.core.adapters;

import com.kodlamaio.hrms.core.adapters.models.MernisPerson;

public interface UserRealCheckService {
	boolean validate(MernisPerson person);
}
