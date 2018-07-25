package com.shelby.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;
import com.shelby.project.models.Role;
import com.shelby.project.repositories.CandidateRepo;
import com.shelby.project.repositories.ConstitRepo;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	private CandidateRepo candRepo;
	private ConstitRepo constitRepo;

	public UserDetailsServiceImplementation(ConstitRepo constitRepo, CandidateRepo candRepo) {
		this.candRepo = candRepo;
		this.constitRepo = constitRepo;
	}

	// 1
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Candidate cand = candRepo.findByUsername(username);
		Constit constit = constitRepo.findByUsername(username);

		if (cand != null) {
			return new org.springframework.security.core.userdetails.User(cand.getUsername(), cand.getPassword(),
					getAuthorities(cand));
		} else if (constit != null) {
			return new org.springframework.security.core.userdetails.User(constit.getUsername(), constit.getPassword(),
					getAuthorities(constit));
		} else {
			throw new UsernameNotFoundException("User not found");

		}
		// if (user == null) {
		// }
		//
		// return new
		// org.springframework.security.core.userdetails.User(user.getUsername(),
		// user.getPassword(),
		// getAuthorities(user));
	}

	// 2
	private List<GrantedAuthority> getAuthorities(Candidate user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}

	private List<GrantedAuthority> getAuthorities(Constit user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}
}
