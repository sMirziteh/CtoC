package com.shelby.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shelby.project.models.Candidate;

@Repository
public interface CandidateRepo extends CrudRepository<Candidate, Long>{

	Candidate findByUsername(String username);
}
