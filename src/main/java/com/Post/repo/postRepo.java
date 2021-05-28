package com.Post.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Post.model.Post;

@Repository
public interface postRepo extends JpaRepository<Post, Long> {
	
	
	

}
