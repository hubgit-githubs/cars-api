package com.ingenosya.carsapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	private String password;
	
	@Column(name = "created_at")
	private Date creationDate;
	
	@Column(name = "updated_at")
	private Date updateDate;

}
