package com.kodlamaio.hrms.business.concretes;


import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.business.BusinessEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.core.utilities.verificationtool.CodeGenerator;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserManager<T extends User> implements UserService<T> {
    private UserDao<T> userDao;

    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(this.userDao.findAll(), Messages.userListed);
    }

    @Override
    public Result add(T t) {
        Result result = BusinessEngine.run(isEmailExist(t.getEmail()));
        if(result.isSuccess()){
            t.setUid(CodeGenerator.generateUuidCode());
        this.userDao.save(t);
        return new SuccessResult(Messages.userAdded);
    }
        return result;
}


    private Result isEmailExist(String email) {
        if(userDao.findByEmail(email).isPresent()){
            return new ErrorResult(Messages.emailExist);
        }
        return new SuccessResult();
    }
}