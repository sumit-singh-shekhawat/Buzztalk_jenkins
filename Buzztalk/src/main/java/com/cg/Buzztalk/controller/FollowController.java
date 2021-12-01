package com.cg.Buzztalk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Buzztalk.exceptionhandling.ResourceNotFoundException;
import com.cg.Buzztalk.model.Follow;
import com.cg.Buzztalk.repository.FollowRepository;

//import com.cg.Buzztalk.exceptionhandling.*;
//import com.cg.Buzztalk.model.*;
//import com.cg.Buzztalk.repository.*;

@RestController
@RequestMapping("/api")
public class FollowController {
	
	@Autowired
	private FollowRepository followRepository;
	
//	all followers
	@GetMapping("/follow")
	public List<Follow> getAllFollow()
	{
		return this.followRepository.findAll();
	}
	
	//====get user by searching id
	@GetMapping("/follow/{id}")
	public ResponseEntity<Follow> getFollowById(@PathVariable(value="id") Long followId) throws ResourceNotFoundException
	{
		Follow follow=followRepository.findById(followId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:"+followId));
		return ResponseEntity.ok().body(follow);
		
	}
	
	
	@PostMapping("follow")
	public Follow createFollow(@RequestBody Follow follow)
	{
		return this.followRepository.save(follow);
		
	}
	
	//============follow using id======================
	@PutMapping("/follow/{id}")
	public ResponseEntity<Follow> updateFollowById(@PathVariable(value = "id") Long followId,
			@RequestBody Follow followDetails) throws ResourceNotFoundException
	{
		Follow follow=followRepository.findById(followId).orElseThrow(()-> new ResourceNotFoundException("User not found for this id:"+followId));
		follow.setEmail(followDetails.getEmail());
		follow.setFirstname(followDetails.getFirstname());
		follow.setLastname(followDetails.getLastname());
		follow.setUserId(followDetails.getUserId());
		return ResponseEntity.ok(this.followRepository.save(follow));
	}
	
	//============Unfollow using id======================
	
	@DeleteMapping("/follow/{id}")
	public Map<String,Boolean>  deleteFollow(@PathVariable(value = "id") Long followId) throws ResourceNotFoundException
	{
		Follow follow=followRepository.findById(followId).orElseThrow(()-> new ResourceNotFoundException("User not found for this id:"+followId));
		this.followRepository.delete(follow);
		
		Map<String, Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}

}
