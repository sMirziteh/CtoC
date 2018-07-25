package com.shelby.project.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="issues")
public class Issue {
	@Id
	@GeneratedValue
	private Long id;
	private String topic;
	private String content;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "candidates_issues",
			joinColumns = @JoinColumn(name = "issue_idc"),
			inverseJoinColumns = @JoinColumn(name = "candidate_id")
			)
	private List<Candidate> supportingCadidates;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="constituent_id")
	private Constit issueAuthor;
	
	public Issue() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Candidate> getSupportingCadidates() {
		return supportingCadidates;
	}

	public void setSupportingCadidates(List<Candidate> supportingCadidates) {
		this.supportingCadidates = supportingCadidates;
	}

	public Constit getIssueAuthor() {
		return issueAuthor;
	}

	public void setIssueAuthor(Constit issueAuthor) {
		this.issueAuthor = issueAuthor;
	}
	
	

}