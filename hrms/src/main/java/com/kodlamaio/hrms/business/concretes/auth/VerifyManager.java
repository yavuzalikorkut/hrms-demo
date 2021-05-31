package com.kodlamaio.hrms.business.concretes.auth;

import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.abstracts.auth.VerifyService;
import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VerifyManager implements VerifyService {

    private final ActivationCodeService activationCodeService;

    @Autowired
    public VerifyManager(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    public Result verify(String uid, String activationCode) {
        Optional<ActivationCode> activation = activationCodeService.getByUserUid(uid).getData();
        Result result = subVerify(activation, activationCode);
        if (!result.isSuccess()) {
            return result;
        }
        activation.get().setConfirmed(true);
        activation.get().setActivationDate(LocalDateTime.now());
        activationCodeService.update(activation.get());
        return new SuccessResult(Messages.codeVerified);
    }

    private Result subVerify(Optional<ActivationCode> activation, String activationCode) {
        if (activation.isEmpty()) {
            return new ErrorResult(Messages.codeNotFound);
        }
        if (activation.get().isConfirmed()) {
            return new ErrorResult(Messages.activationExist);
        }
        if (activation.get().getExpirationDate().isBefore(LocalDateTime.now())) {
            return new ErrorResult(Messages.codeExpired);
        }
        if (!activation.get().getActivationCode().equals(activationCode)) {
            return new ErrorResult(Messages.codeNotEqual);
        }
        return new SuccessResult();
    }
}