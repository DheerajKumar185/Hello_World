package com.tech.lti.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech.lti.mongodb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
