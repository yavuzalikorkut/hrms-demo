package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService<T extends User> {
	DataResult<List<T>>getAll();
	Result add(T t);
}
