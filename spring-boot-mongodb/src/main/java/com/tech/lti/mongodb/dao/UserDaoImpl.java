package com.tech.lti.mongodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.lti.mongodb.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public User addUser(User user) {
		mongoTemplate.save(user);
		// Now, user object will contain the ID as well
		return user;
	}

	@Override
	public Object getQualification(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getQualification() : "User not found.";
	}

	@Override
	public String getQualification(String userId, String standard) {
		Query query = new Query();
		query.fields().include("qualification");
		query.addCriteria(Criteria.where("userId").is(userId)
				.andOperator(Criteria.where("qualification." + standard).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getQualification().get(standard) : "Not found.";
	}

	@Override
	public String addQualification(String userId, String standard, String year) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if (user != null) {
			user.getQualification().put(standard, year);
			mongoTemplate.save(user);
			return "added.";
		} else {
			return "User not found.";
		}
	}
}
