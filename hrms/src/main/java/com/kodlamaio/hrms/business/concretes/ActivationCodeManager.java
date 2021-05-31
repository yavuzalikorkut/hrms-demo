package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.core.utilities.verificationtool.CodeGenerator;
import com.kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import com.kodlamaio.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActivationCodeManager implements ActivationCodeService {
    private final ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(), Messages.activationCodeListed);
    }

    @Override
    public Result add(ActivationCode activationCode) {
        activationCode.setExpirationDate(LocalDateTime.now().plusMinutes(5));
        activationCode.setUid(CodeGenerator.generateUuidCode());
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeAdded);
    }

    @Override
    public Result update(ActivationCode activationCode) {
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeUpdated);
    }

    @Override
    public DataResult<Optional<ActivationCode>> getByUserUid(String uid) {
        return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserUid(uid));
    }
    
}