package com.ingenosya.carsapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comment;
	
	@Column(name = "created_at")
	private Date creationDate;
	
	@Column(name = "updated_at")
	private Date updateDate;
	
	@ManyToOne
	private Users users;
	@ManyToOne
	private Cars cars;
	
	

}
