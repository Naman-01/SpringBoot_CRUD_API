package com.Post.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Post.exception.Exception;
import com.Post.model.Post;
import com.Post.repo.postRepo;

@RestController
@RequestMapping(path = "/post", consumes = "application/json")
public class postController {
	
	
	@Autowired
	private  postRepo Repo ;
	
	@GetMapping("/getpost")
	public List<Post> getAllPost() {
		return Repo.findAll();
		}
	@GetMapping("/getpost/{id}")
	public Post getPostById(@PathVariable(value = "id" ) Long i ) {
		 return Repo.findById(i).orElseThrow(() -> new Exception("Post Not Found") );
		
	}
	
	@PostMapping("/createpost")
	public Post createPost(@Valid @RequestBody Post post) {
		Optional<Post> post2 = Repo.findById(post.getpID());
		
		if(post2.isEmpty())
		{
			return Repo.save(post);
		}
		return post2.get();
			
	}
	
	@PutMapping("/updatepost/{id}")
	public Post updatePost(@Valid @RequestBody Post post , @PathVariable(value = "/{id}") Long id )
	{
		Post existingPost = Repo.findById(id).orElseThrow(()->new Exception("User Not found") );
		
		existingPost.setpTittle(post.getpTittle());
		existingPost.setpDesc(post.getpDesc());
		Repo.save(existingPost);
		return existingPost;
	}
	
	@DeleteMapping("deletepost//{id}")
	public Post deletePost(@PathVariable (value = "/{id}") Long id)
	{
		Post post = Repo.findById(id).orElseThrow(()->new Exception("Post Not Found"));
		Repo.delete(post);
			return post;
	}
	
	
	

}
