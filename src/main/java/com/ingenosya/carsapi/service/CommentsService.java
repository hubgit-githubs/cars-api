package com.ingenosya.carsapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenosya.carsapi.model.Comments;
import com.ingenosya.carsapi.repository.CommentsRepository;

import lombok.Data;

@Data
@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	public Optional<Comments> getComment(final Integer id){
		return commentsRepository.findById(id);
	}
	
	public Iterable<Comments> getComments(final Integer carsId){
		return commentsRepository.findByCarsId(carsId);
	}
	
	public void deleteComment(final Integer id) {
		commentsRepository.deleteById(id);
	}
	
	public Comments saveComment(Comments comment) {
		Comments savedComment = commentsRepository.save(comment);
		return savedComment;
	}
	

}
