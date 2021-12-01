package com.cg.Buzztalk.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="comments")
public class Comment 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private Instant createddate;
	private  String text;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="postId",referencedColumnName="postId")
	private Post post;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="fileId",referencedColumnName="fileId")
	private FileDb files;
	
	public Comment() {
		super();
	}

	public Comment(Long id, Instant createddate, String text, Post post, FileDb files) {
		super();
		this.id = id;
		this.createddate = createddate;
		this.text = text;
		this.post = post;
		this.files = files;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Instant createddate) {
		this.createddate = createddate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public FileDb getFiles() {
		return files;
	}

	public void setFiles(FileDb files) {
		this.files = files;
	}

	
	

}
