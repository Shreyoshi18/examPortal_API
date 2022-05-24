package com.exam.entity.exam;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	private String title;
	private String description;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quiz;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String title, String description, Set<Quiz> quiz) {
		super();
		this.title = title;
		this.description = description;
		this.quiz = quiz;
	}
	

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Quiz> getQuiz() {
		return quiz;
	}

	public void setQuiz(Set<Quiz> quiz) {
		this.quiz = quiz;
	}
	
	
	

}
