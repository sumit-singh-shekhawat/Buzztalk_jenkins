package com.cg.Buzztalk.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Posts")
public class Post 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
	
	@ManyToOne(cascade =CascadeType.ALL)
	private DAOUser daouser;
	
	@OneToMany(cascade =CascadeType.ALL)
	//@JoinColumn(name="id",referencedColumnName="id")
	private List<Comment> comment;
    
	 private String content;
	 
	 private Date createdDate;

	

	public Post() {
		super();
	}



	


	public Post(Integer postId, DAOUser daouser, List<Comment> comment, String content, Date createdDate) {
		super();
		this.postId = postId;
		this.daouser = daouser;
		this.comment = comment;
		this.content = content;
		this.createdDate = createdDate;
	}






	public Integer getPostId() {
		return postId;
	}



	public void setPostId(Integer postId) {
		this.postId = postId;
	}



	


	public DAOUser getDaouser() {
		return daouser;
	}





	public void setDaouser(DAOUser daouser) {
		this.daouser = daouser;
	}





	public List<Comment> getComment() {
		return comment;
	}



	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public void setComment(String text) 
	{
		Comment comment = new Comment();
		comment.getText();
		
	}

	

}
