package com.cg.Buzztalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Buzztalk.model.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long>{

}
