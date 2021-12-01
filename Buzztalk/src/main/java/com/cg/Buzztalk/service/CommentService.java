package com.cg.Buzztalk.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Buzztalk.model.Comment;
import com.cg.Buzztalk.repository.CommentRepository;

@Service
public class CommentService 
{
	@Autowired
	
	private CommentRepository commentRepository;

	public Comment save(Comment comment) 
	{
		
		return commentRepository.save(comment);
	}

	public Comment save1(String text)
	{
		// TODO Auto-generated method stub
		return commentRepository.save(text);
	}

	public Comment saveComment(Comment comment) {
		
		return commentRepository.save(comment);
	}

	

}
