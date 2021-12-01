package com.cg.Buzztalk.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Buzztalk.model.Post;
import com.cg.Buzztalk.repository.PostRepository;
import com.cg.Buzztalk.repository.UserDao;
import com.cg.Buzztalk.service.PostService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class UploadPostController
{
	@Autowired
	private PostService postservice;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserDao userDao;
	
	/*@Autowired
	private UserRepository userRepository;*/
	
//	@PostMapping
//	public Post addPost(@RequestParam("content") String content, @PathVariable Integer postId)
//	{
//		//Post post = new Post();
//		Post post=postRepository.findById1(postId);
//		return postservice.savePost(post);
//	}
	
	
	/*(@PathVariable(value = "postId") Integer postId,
			@RequestBody Comment comment) throws ResourceNotFoundException*/
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Post addPost( @RequestBody Post post)
	{
		   
		//User user = regRepository.findUserById(id);
       // user.setId(post.getContent());
        //System.out.println("User id is"+id);
		//user.setId(id);
		//Optional<User> user1=regRepository.findById(id);
		
		return this.postservice.savePost(post);
		
		}
	//@CrossOrigin("/http://localhost:4200")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Post getPost(@PathVariable(value="id") Integer Id)
	{
		return postRepository.getById(Id);
		
	}
	
	  @CrossOrigin(origins = "http://localhost:4200")
	  @GetMapping("/list")
	  public List<Post> gePostList()
	  {
		  
		  return postservice.getPostList();
		
	  }
	 
	   @CrossOrigin(origins = "http://localhost:4200")
	   @DeleteMapping("/delete/{id}")
	   public void deleteFile(@PathVariable("id") Integer postId)
	   {
		  postservice.delete(postId);
		   System.out.println("File deleted successfully...");
		  
	   }
	  
	   @CrossOrigin("/http://localhost:4200")
	   @DeleteMapping("/deleteAll")
	   public void deleteAllFile()
	   {
		   postservice.deleteAll();
		   System.out.println(" All File deleted successfully...");
	   }
	   
	   
	}
	
