package com.me.app.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="story")

public class Story {
	
	@Id
	@GeneratedValue
	@Column(name="storyId",unique=true,nullable=false)
	private int storyId;
	
	@Column(name="storyTitle")
	private String storyTitle;
	
	@Column(name="storyDescription")
	private String storyDescription;
	
	@Column(name="comments")
	private String comments;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personId")
	private User createdBy;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username")
	private User assignedTo;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="statusId")
	private Status status;
	
	@Transient
	private String statusName;
	
	@Column(name="createdDate")
	private String createdDate;
	
	@Column(name="points")
	private int points;

	@Transient
	private String username;
	
	@JoinColumn(name="sprintId")
	@OneToOne(fetch=FetchType.EAGER)
	private Sprint sprintId;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="subtaskId")
	private Set<Subtask> tasks=new HashSet<Subtask>();

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getStoryDescription() {
		return storyDescription;
	}

	public void setStoryDescription(String storyDescription) {
		this.storyDescription = storyDescription;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Set<Subtask> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Subtask> tasks) {
		this.tasks = tasks;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Sprint getSprintId() {
		return sprintId;
	}

	public void setSprintId(Sprint sprintId) {
		this.sprintId = sprintId;
	}

	

}
