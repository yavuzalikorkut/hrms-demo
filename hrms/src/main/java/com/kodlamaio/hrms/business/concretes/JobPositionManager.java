package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.JobPositionService;
import com.kodlamaio.hrms.business.constant.Messages;
import com.kodlamaio.hrms.core.utilities.business.BusinessEngine;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.core.utilities.verificationtool.CodeGenerator;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;


    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll(), Messages.jobPositionListed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        Result result = BusinessEngine.run(isJobPositionExist(jobPosition));
        if (result.isSuccess()) {
            jobPosition.setUid(CodeGenerator.generateUuidCode());
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult(Messages.jobPositionAdded);
        }
        return result;
    }


    private Result isJobPositionExist(JobPosition jobPosition) {
        if (jobPositionDao.findByTitle(jobPosition.getTitle()).isPresent()) {
            return new ErrorResult(Messages.jobTitleExist);
        }
        return new SuccessResult();
    }
}
