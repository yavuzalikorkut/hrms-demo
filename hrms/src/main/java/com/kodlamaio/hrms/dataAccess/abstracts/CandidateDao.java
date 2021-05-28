package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import com.kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate>{
	Optional<Candidate> findByNationalIdentity(String nationalIdentity);
}
