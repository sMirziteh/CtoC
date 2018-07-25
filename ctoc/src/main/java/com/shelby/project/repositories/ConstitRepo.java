package com.shelby.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shelby.project.models.Constit;

@Repository
public interface ConstitRepo extends CrudRepository<Constit, Long>{

	Constit findByEmail(String email);
}
