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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="candidates")
public class Candidate{
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
	private String pparty;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	private String profilePic;
	private Integer phone;
	private String website;
	private String linkedin;
	private String facebook;
	private String Instagram;
	private Integer district;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name="user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "candidates_issues",
			joinColumns = @JoinColumn(name = "candidate_id"),
			inverseJoinColumns = @JoinColumn(name = "issue_id")
			)
	private List<Issue> platform;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "candidates_constituents",
			joinColumns = @JoinColumn(name = "candidate_id"),
			inverseJoinColumns = @JoinColumn(name = "constituent_id")
			)
	private List<Constit> constituents;
	
	public Candidate() {
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

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return Instagram;
	}

	public void setInstagram(String instagram) {
		Instagram = instagram;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Issue> getPlatform() {
		return platform;
	}

	public void setPlatform(List<Issue> platform) {
		this.platform = platform;
	}

	public List<Constit> getConstituents() {
		return constituents;
	}

	public void setConstituents(List<Constit> constituents) {
		this.constituents = constituents;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public String getPparty() {
		return pparty;
	}

	public void setPparty(String pparty) {
		this.pparty = pparty;
	}

	
}