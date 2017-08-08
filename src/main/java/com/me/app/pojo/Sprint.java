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
import javax.persistence.Table;

@Entity
@Table(name="Sprint")
public class Sprint {
	
	@Id
	@GeneratedValue
	@Column(name="sprintId",unique=true,nullable=false)
	private int sprintId;
	
	@Column(name="sprintName")
	private String sprintName;
	
	@OneToMany(fetch=FetchType.EAGER)	
	@JoinColumn(name="sprintId")
	private Set<Story> stories=new HashSet<Story>();
	
	public Sprint(){
		
	}
	
	public Sprint(String sprintName){
		this.sprintName=sprintName;
	}
	
	public Sprint(int sprintId){
		this.sprintId=sprintId;
		this.stories=new HashSet<Story>();
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public Set<Story> getStories() {
		return stories;
	}

	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}

	
	

}
