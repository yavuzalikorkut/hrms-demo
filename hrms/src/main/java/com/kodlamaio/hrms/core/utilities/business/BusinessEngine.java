package com.kodlamaio.hrms.core.utilities.business;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessEngine {
	public static Result run(Result... logics){
		for(Result logic:logics){
			if(!logic.isSuccess()){
                return logic;
            }
		}
		return new SuccessResult();
	}
}
