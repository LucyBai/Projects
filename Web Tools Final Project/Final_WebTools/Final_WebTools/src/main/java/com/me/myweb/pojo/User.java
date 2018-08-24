package com.me.myweb.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "user_table")
@PrimaryKeyJoinColumn(name = "personID")
public class User extends Person {

	@Column(name = "userName")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name="role")
	private String role;
	
	@Column(name = "bio")
	private String bio;
	
	@Column(name="status")
	private String status;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_follower_table", joinColumns = { @JoinColumn(name = "personID_fk") },
			 inverseJoinColumns = {@JoinColumn(name = "followerID_fk") })
	private Set<User> followers = new HashSet<User>();
	

	@OneToMany(mappedBy = "user" ,cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Artical> artical = new HashSet<Artical>();

	public User() {

	}

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Artical> getArtical() {
		return artical;
	}

	public void setArtical(Set<Artical> artical) {
		this.artical = artical;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
