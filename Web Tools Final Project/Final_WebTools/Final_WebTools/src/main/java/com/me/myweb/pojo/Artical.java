package com.me.myweb.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "artical_table")
public class Artical {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "articalID", unique=true, nullable = false)
	private long articalID;
	
	@Column(name="favoriteCount")
	private int favoriteCount;
	
	@Transient
	private CommonsMultipartFile pic;
	
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="articalName")
	private String articalName;
	
	@Column(name="content")
	private String content;
	 
	@Column(name="type")
	private String type; 
	
	@Column(name="uploadDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date uploadDate;

	@ManyToOne
	@JoinColumn(name="personID_fk")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="favoriteArtical",orphanRemoval=true)
	private Set<Favorite> favorite = new HashSet<Favorite>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="commentArtical",orphanRemoval=true)
	private Set<Comment> comments = new HashSet<Comment>();
	
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CommonsMultipartFile getPic() {
		return pic;
	}

	public void setPic(CommonsMultipartFile pic) {
		this.pic = pic;
	}

	public long getArticalID() {
		return articalID;
	}

	public void setArticalID(long articalID) {
		this.articalID = articalID;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public String getArticalName() {
		return articalName;
	}

	public void setArticalName(String articalName) {
		this.articalName = articalName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(Set<Favorite> favorite) {
		this.favorite = favorite;
	}
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
