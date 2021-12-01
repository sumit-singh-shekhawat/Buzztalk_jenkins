package com.cg.Buzztalk.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Buzztalk.model.DAOUser;
import com.cg.Buzztalk.model.Post;

@Repository
public interface PostRepository extends JpaRepository <Post,Integer> {

	Post save(Post post);

	Optional<Post> findById(Integer postId);
	
	//Post findById1(Integer postId);

	List<Post> findAll();

	void deleteAll();

	Post getById(Integer id);

	void deleteById(Integer id);

	//void findById(Post post);
	
	Post findBypostId(Integer postId );

	//Post saveUser(User user);

	Post save(DAOUser daouser);

}
