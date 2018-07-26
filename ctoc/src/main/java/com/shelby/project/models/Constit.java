package com.shelby.project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="constituents")
public class Constit {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Size(min=8, message="Password must be greater than 8 characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	@Email
	private String username;
	@Size(min=2, message="City/Town name must be longer than 2 characters")
	private String city;
	private String state;
	private String zipcode;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name="user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "candidates_constituents",
			joinColumns = @JoinColumn(name = "constituent_id"),
			inverseJoinColumns = @JoinColumn(name = "candidate_id")
			)
	private List<Candidate> candidates;

	@OneToMany(mappedBy="issueAuthor", fetch=FetchType.LAZY)
	private List<Issue> raisedIssues;
	
	public Constit() {
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public List<Candidate> getCandidates() {
		return candidates;
	}



	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}



	public List<Issue> getRaisedIssues() {
		return raisedIssues;
	}



	public void setRaisedIssues(List<Issue> raisedIssues) {
		this.raisedIssues = raisedIssues;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	
}
