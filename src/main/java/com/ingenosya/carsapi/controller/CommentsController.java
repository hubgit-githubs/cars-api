package com.ingenosya.carsapi.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingenosya.carsapi.model.Cars;
import com.ingenosya.carsapi.model.Comments;
import com.ingenosya.carsapi.model.Users;
import com.ingenosya.carsapi.service.CommentsService;

@RestController
public class CommentsController {
	
	@Autowired
	private CommentsService commentService;
	
	@GetMapping("/comments/{id}")
	public Iterable<Comments> getComments(@PathVariable("id") final Integer carsId){
		return commentService.getComments(carsId);
	}
	
	@GetMapping("/comment/{id}")
	public Optional<Comments> getComment(@PathVariable final Integer id){
		return commentService.getComment(id);
		
	}
	@PostMapping("/comment")
	public Comments saveComment(@RequestBody Comments comment) {
		return commentService.saveComment(comment);
	}
	
	@PutMapping("/comment/{id}")
	public Comments updateComment(@PathVariable("id") Integer id, @RequestBody Comments comments){
		Optional<Comments> c = commentService.getComment(id);
		if(c.isPresent()) {
			Comments currentComment = c.get();
			
			String comment = comments.getComment();
			if(comment != null) 
				currentComment.setComment(comment);

			Date creationDate = comments.getCreationDate();
			if(creationDate != null)
				currentComment.setCreationDate(creationDate);
			
			Date updateDate = comments.getUpdateDate();
			if (updateDate != null)
				currentComment.setUpdateDate(updateDate);
			
			Users users = comments.getUsers();
			if (users != null)
				currentComment.setUsers(users);
			
			Cars cars = comments.getCars();
			if (cars != null)
				currentComment.setCars(cars);
			
			commentService.saveComment(currentComment);
			
			return currentComment;
		}else
			return null;
		
	}
	
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable Integer id) {
		commentService.deleteComment(id);
	}

}
