package com.mt.rideshare.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mt.rideshare.db.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(@Param("userId") String userId);
	String findByEmail(@Param("userId") String userId);
	String findByPhoneNo(@Param("userId") String userId);
}