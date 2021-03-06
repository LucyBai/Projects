package com.me.myweb.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comment_table")
public class Comment {
	
	public Comment(){}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentID", unique = true, nullable = false)
	private long commentID;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="articalID")
	private Artical commentArtical;
	
	@Column(name="commentContent")
	private String commentContent;
	
	@Column(name="commentTime")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date commentTime;
	
	@ManyToOne
	@JoinColumn(name="personID_fk")
	private User user;
	
	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public long getCommentID() {
		return commentID;
	}

	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}


	public Artical getCommentArtical() {
		return commentArtical;
	}

	public void setCommentArtical(Artical commentArtical) {
		this.commentArtical = commentArtical;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
