package com.me.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="subtask")
public class Subtask {
		
		@Id
		@GeneratedValue
		@Column(name="subtaskId",unique=true,nullable=false)
		private int subtaskId;
		
		@Column(name="subtaskTitle")
		private String subtaskTitle;
		
		@Column(name="subtaskDescription")
		private String subtaskDescription;
		
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
		
		@Column(name="createdDate")
		private String createdDate;
		
		@Column(name="isDefect")
		private String isDefect;
		
		@Transient
		private String statusName;
		
		@Transient
		private String username;
		
		@JoinColumn(name="storyId")
		@OneToOne(fetch=FetchType.EAGER)
		private Story storyId;

		public int getSubtaskId() {
			return subtaskId;
		}

		public void setSubtaskId(int subtaskId) {
			this.subtaskId = subtaskId;
		}

		public String getSubtaskTitle() {
			return subtaskTitle;
		}

		public void setSubtaskTitle(String subtaskTitle) {
			this.subtaskTitle = subtaskTitle;
		}

		public String getSubtaskDescription() {
			return subtaskDescription;
		}

		public void setSubtaskDescription(String subtaskDescription) {
			this.subtaskDescription = subtaskDescription;
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

		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}

		public String getIsDefect() {
			return isDefect;
		}

		public void setIsDefect(String isDefect) {
			this.isDefect = isDefect;
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

		public Story getStoryId() {
			return storyId;
		}

		public void setStoryId(Story storyId) {
			this.storyId = storyId;
		}
		
		
		
		
	}

