package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import com.kodlamaio.hrms.business.abstracts.JobPositionService;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPosition; 
	
	public JobPositionManager(JobPositionDao jobPosition) {
		super();
		this.jobPosition = jobPosition;
	}

	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPosition.findAll();
	}


}
