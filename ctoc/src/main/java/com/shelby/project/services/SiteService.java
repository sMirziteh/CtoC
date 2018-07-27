package com.shelby.project.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;
import com.shelby.project.models.Issue;
import com.shelby.project.repositories.CandidateRepo;
import com.shelby.project.repositories.ConstitRepo;
import com.shelby.project.repositories.IssueRepo;
import com.shelby.project.repositories.RoleRepo;

@Service
public class SiteService {

	private CandidateRepo candRepo;
	private ConstitRepo constitRepo;
	private RoleRepo roleRepo;
	private IssueRepo is;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public SiteService(CandidateRepo candRepo, ConstitRepo constitRepo, RoleRepo roleRepo, IssueRepo is, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.candRepo = candRepo;
		this.constitRepo = constitRepo;
		this.roleRepo = roleRepo;
		this.is = is;
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

	public Constit findConstByusername(String email) {
		return constitRepo.findByUsername(email);
	}

	public void savePicPath(String filePath, Constit constit) {
		constit.setProfilePic(filePath);
		constitRepo.save(constit);
		
	}

	public void savePicPath(String filePath, Candidate candid) {
		candid.setProfilePic(filePath);
		candRepo.save(candid);
		
	}

	public void saveNewIssue(Principal principal, @Valid Issue issue) {
		Constit c = findConstByusername(principal.getName());
		issue.setIssueAuthor(c);
		is.save(issue);
	}
	
	public List<Candidate> getAllCandidates(){
		return candRepo.findAll();
	}
	
	public Candidate findCandidateById(Long id) {
		Optional<Candidate> opcand = candRepo.findById(id);
		if(opcand.isPresent()) {
			return opcand.get();
		} else {
			return null;
		}
	}
}
