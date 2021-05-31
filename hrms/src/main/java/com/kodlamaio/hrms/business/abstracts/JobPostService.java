package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPost;

import java.util.List;

public interface JobPostService {
    public Result add(JobPost jobPost);

    Result changeActive(int postId);

    public DataResult<List<JobPost>> getAll();

    public DataResult<List<JobPost>> getAllByActivated();

    public DataResult<List<JobPost>> getAllByActivatedAndByDay(int day);

    public DataResult<List<JobPost>> getAllByActivatedAndByEmployer(int employerId);
}