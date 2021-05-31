package com.kodlamaio.hrms.business.abstracts.auth;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.abstracts.Dto;
import com.kodlamaio.hrms.entities.abstracts.User;

public interface UserAuthService<TDto extends Dto, TUser extends User> {
    Result register(TDto tDto);

    Result reSendMail(String uid);
    
}
