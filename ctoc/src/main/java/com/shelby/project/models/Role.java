package com.shelby.project.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String name;
 @ManyToMany(mappedBy = "roles")
 private List<Candidate> candidates;

 @ManyToMany(mappedBy = "roles")
 private List<Constit> Constituents;
 
 public Role() {
 }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Candidate> getCandidates() {
	return candidates;
}

public void setCandidates(List<Candidate> candidates) {
	this.candidates = candidates;
}

public List<Constit> getConstituents() {
	return Constituents;
}

public void setConstituents(List<Constit> constituents) {
	Constituents = constituents;
}
 
 
}
