package com.cg.Buzztalk.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FILESDATA")
public class FileDb
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String fileId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<DAOUser> daouser;
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy="files")
	private List<Comment> comment;
	
	
	
	private String name;
	
	
	private String type;

	@Lob
	private byte[] data;

	public FileDb() {
		
	}
	

	


	public FileDb(String fileId, Set<DAOUser> daouser, List<Comment> comment, String name, String type, byte[] data) {
		super();
		this.fileId = fileId;
		this.daouser = daouser;
		this.comment = comment;
		this.name = name;
		this.type = type;
		this.data = data;
	}





	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}


	

	public Set<DAOUser> getDaouser() {
		return daouser;
	}





	public void setDaouser(Set<DAOUser> daouser) {
		this.daouser = daouser;
	}





	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}


	public void setComment(String text)
	{
		Comment comment = new Comment();
		comment.getText();
		
		Post post = new Post();
		post.getPostId();
		
		FileDb file = new FileDb();
		file.getDaouser();
		
	}

	
}



