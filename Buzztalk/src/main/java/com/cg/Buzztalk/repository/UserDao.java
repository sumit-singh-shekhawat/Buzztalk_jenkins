package com.cg.Buzztalk.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.Buzztalk.model.DAOUser;



@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	public DAOUser findUserById(Long id);
	
}