package com.cg.Buzztalk.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




@Entity
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_posts", joinColumns={@JoinColumn(name="id")}, inverseJoinColumns={@JoinColumn(name="postId")})
	private List<Post> post;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_files", joinColumns={@JoinColumn(name="id")}, inverseJoinColumns={@JoinColumn(name="fileId")})
	private List <FileDb> filedb;
	
	//@OneToMany(cascade =CascadeType.ALL,mappedBy="user")
	//private List<Comment> comment;
	
	private String emailId;
	private String username;
	private String password;
	

	public DAOUser() {
		super();
	}


	public DAOUser(Long id, List<Post> post, List<FileDb> filedb, String emailId, String username, String password) {
		super();
		this.id = id;
		this.post = post;
		this.filedb = filedb;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
	}


	




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Post> getPost() {
		return post;
	}


	public void setPost(List<Post> post) {
		this.post = post;
	}


	public List<FileDb> getFiledb() {
		return filedb;
	}


	public void setFiledb(List<FileDb> filedb) {
		this.filedb = filedb;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
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


	public void setId(String content) 
	{
		Post post = new Post();
		post.getContent();
		
	}
  /* public void setId(byte[] data)
   {
	   FileDb file = new FileDb();
	   file.getData();
	   
   }*/

	

	
	
}

