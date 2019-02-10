package com.tech.lti.mongodb.dao;

import java.util.List;

import com.tech.lti.mongodb.model.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addUser(User user);

	Object getQualification(String userId);

	String getQualification(String userId, String standard);

	String addQualification(String userId, String standard, String year);
}