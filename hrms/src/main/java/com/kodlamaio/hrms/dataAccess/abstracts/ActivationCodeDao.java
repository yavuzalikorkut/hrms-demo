package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{
	Optional<ActivationCode> findByUserUid(String uid);
}
