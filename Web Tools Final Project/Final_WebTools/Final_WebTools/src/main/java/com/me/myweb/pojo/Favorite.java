package com.me.myweb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="like_table")
public class Favorite {
	
	
	public Favorite(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "favoriteID", unique=true, nullable = false)
	private long favoriteID;
	
	
	@ManyToOne
	@JoinColumn(name="articalID_fk")
	private Artical  favoriteArtical;
	
	@OneToOne
	@JoinColumn(name="personID_fk")
	private User user;

	public long getFavoriteID() {
		return favoriteID;
	}

	public void setFavoriteID(long favoriteID) {
		this.favoriteID = favoriteID;
	}

          

	public Artical getFavoriteArtical() {
		return favoriteArtical;
	}

	public void setFavoriteArtical(Artical favoriteArtical) {
		this.favoriteArtical = favoriteArtical;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
