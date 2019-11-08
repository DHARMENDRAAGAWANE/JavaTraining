package com.mt.daretotry.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mt.daretotry.entity.User;

public interface UserReposiotry extends MongoRepository<User, String> {

	 public User findByFirstName(String firstName);
	    public List<User> findByLastName(String lastName);

}
