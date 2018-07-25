package com.shelby.project.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;
import com.shelby.project.repositories.CandidateRepo;
import com.shelby.project.repositories.ConstitRepo;
import com.shelby.project.repositories.RoleRepo;

@Service
public class SiteService {

	private CandidateRepo candRepo;
	private ConstitRepo constitRepo;
	private RoleRepo roleRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public SiteService(CandidateRepo candRepo, ConstitRepo constitRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.candRepo = candRepo;
		this.constitRepo = constitRepo;
		this.roleRepo = roleRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithCandRole(Candidate cand) {
		cand.setPassword(bCryptPasswordEncoder.encode(cand.getPassword()));
		cand.setRoles(roleRepo.findByName("ROLE_CAND"));
		candRepo.save(cand);
	}

	public void saveWithConstRole(Constit constit) {
		constit.setPassword(bCryptPasswordEncoder.encode(constit.getPassword()));
		constit.setRoles(roleRepo.findByName("ROLE_CONST"));
		constitRepo.save(constit);
	}
	
	public Candidate findCandByUsername(String email) {
		return candRepo.findByUsername(email);
	}

	public Constit findConstByEmail(String email) {
		return constitRepo.findByUsername(email);
	}
}
