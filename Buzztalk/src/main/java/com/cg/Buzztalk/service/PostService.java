package com.cg.Buzztalk.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Buzztalk.model.DAOUser;
import com.cg.Buzztalk.model.Post;
import com.cg.Buzztalk.repository.PostRepository;

@Service
public class PostService
{
	@Autowired
	private PostRepository postrepo;

	public Post savePost(String content) 
	{
		content.chars();
		Integer postId = null;
		Date createdate;
		Set<DAOUser> daouser=new HashSet();
		daouser.addAll(daouser);
//		List<Comment> com =new ArrayList();
//		com.add((Comment) com);
		//LocalDate createdate2 = createdate.toLocalDate();
		Post post = new Post();
		return postrepo.save(post);
	}

	public Post getPostById(Integer postId)
	{
		return postrepo.findBypostId(postId);
		
	}

	public List<Post> getPostList()
	{
		
		return postrepo.findAll();
	}


	public void deleteAll() 
	{
		postrepo.deleteAll();
		
	}

	public void delete(Integer id)
	{
		postrepo.deleteById(id);
		
	}

	

	public Post savePost(Post post)
	{
		
		return postrepo.save(post);
		
	}

	


}
