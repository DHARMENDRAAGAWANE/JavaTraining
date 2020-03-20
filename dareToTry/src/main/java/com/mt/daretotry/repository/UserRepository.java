package com.mt.daretotry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mt.daretotry.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(final String userName);
	
	

}
