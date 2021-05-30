package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.Optional;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{
	Optional<JobPosition> findByTitle(String title);
}
