package com.shelby.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shelby.project.models.Candidate;

@Repository
public interface CandidateRepo extends CrudRepository<Candidate, Long>{

	List<Candidate> findAll();
	Candidate findByUsername(String username);
}
