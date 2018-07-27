package com.shelby.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shelby.project.models.Issue;

@Repository
public interface IssueRepo extends CrudRepository<Issue, Long>{

	List<Issue> findAll();
}
