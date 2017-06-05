package com.slowe;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.slowe.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

	User findByUserName(String name);
}
