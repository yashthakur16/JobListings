package com.yash.Joblisting.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.Joblisting.Repository.PostDB;
import com.yash.Joblisting.Repository.SearchRepository;
import com.yash.Joblisting.model.Post;

import springfox.documentation.annotations.ApiIgnore;


@RestController
public class PostController 
{
	@ApiIgnore
	@RequestMapping("/")
	public void redirect(HttpServletResponse response) throws IOException
	{
		response.sendRedirect("/swagger-ui.html");
	}
	
	@Autowired
	PostDB db;
	
	@Autowired
	SearchRepository srepo;
	
	@GetMapping("/getPosts")
	public List<Post> getPosts()
	{
		List<Post> posts=db.findAll();
		return posts;
		
	}
	
	@PostMapping("/Post")
	public void Post(@RequestBody Post p)
	{
		db.save(p);
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> findall(@PathVariable String text)
	{
		return srepo.findByText(text);
	}
}
