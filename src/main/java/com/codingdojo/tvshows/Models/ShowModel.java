package com.codingdojo.tvshows.Models;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="tvshows")
public class ShowModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=255, message="Title must be at least 2 characters.")
	private String title;

	@Size(min=2, max=255, message="Title must be at least 2 characters.")
	private String network;
	
	
	private Double rating;
	

	
	private Date createdAt;
	private Date updatedAt;
	@PrePersist
	public void OnCreate() { createdAt = new Date(); }

	@PreUpdate
	public void OnUpdate() { updatedAt = new Date(); }
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User creator;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "joinshows",
		joinColumns=@JoinColumn(name = "showModel_id"),
		inverseJoinColumns=@JoinColumn(name = "user_id")
	)
	private List<User> users;
	
	
	@OneToMany(mappedBy = "reviewer")
	private List<ReviewModel> reviewModel;
	
	
	

	
	
	

	public List<ReviewModel> getReviewModel() {
		return reviewModel;
	}

	public void setReviewModel(List<ReviewModel> reviewModel) {
		this.reviewModel = reviewModel;
	}

	public ShowModel() {	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
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
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
}

