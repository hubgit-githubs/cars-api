package com.ingenosya.carsapi.repository;


import org.springframework.data.repository.CrudRepository;

import com.ingenosya.carsapi.model.Comments;

public interface CommentsRepository extends CrudRepository <Comments, Integer>{
	
	public Iterable<Comments> findByCarsId(final Integer carsId);


}
