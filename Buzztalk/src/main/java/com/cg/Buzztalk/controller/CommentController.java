package com.cg.Buzztalk.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Buzztalk.exceptionhandling.ResourceNotFoundException;
import com.cg.Buzztalk.model.Comment;
import com.cg.Buzztalk.model.FileDb;
import com.cg.Buzztalk.model.Post;
import com.cg.Buzztalk.repository.CommentRepository;
import com.cg.Buzztalk.repository.FileDbRepository;
import com.cg.Buzztalk.repository.PostRepository;
import com.cg.Buzztalk.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController 
{
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private FileDbRepository fileRepository;
	
	@Autowired 
	private CommentService commentService;
	
	@PostMapping("/{postId}/comment")
	public ResponseEntity<Comment> addComent(@PathVariable(value = "postId") Integer postId,
			@RequestBody Comment comment) throws ResourceNotFoundException
			{
		
		     Post post = postRepository.findBypostId(postId);
		     post.setComment(comment.getText());
		     return ResponseEntity.ok(commentService.save(comment));
		    		 
   }
	@PostMapping("/{fileId}")
	public ResponseEntity<Comment> addComent(@PathVariable(value = "fileId") String fileId,
			@RequestBody Comment comment) throws ResourceNotFoundException
			{
	            FileDb file = fileRepository.findByFileId(fileId);
	            file.setComment(comment.getText());
	            return ResponseEntity.ok(commentService.saveComment(comment));
	
	

}
}
