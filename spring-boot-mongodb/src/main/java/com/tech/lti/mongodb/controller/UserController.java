package com.tech.lti.mongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.lti.mongodb.dao.UserDao;
import com.tech.lti.mongodb.dao.UserRepository;
import com.tech.lti.mongodb.model.User;

@RestController
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDao userDao;

	public UserController(UserRepository userRepository, UserDao userDao) {
		this.userRepository = userRepository;
		this.userDao = userDao;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findOne(userId);
	}

	@RequestMapping(value = "/qualification/{userId}", method = RequestMethod.GET)
	public Object getQualification(@PathVariable String userId) {
		User user = userRepository.findOne(userId);
		if (user != null) {
			return userDao.getQualification(userId);
		} else {
			return "User not found.";
		}
	}

	@RequestMapping(value = "/qualification/{userId}/{standard}", method = RequestMethod.GET)
	public String getQualification(@PathVariable String userId, @PathVariable String standard) {
		return userDao.getQualification(userId, standard);
	}

	@RequestMapping(value = "/qualification/{userId}/{standard}/{year}", method = RequestMethod.GET)
	public String addQualification(@PathVariable String userId, @PathVariable String standard,
			@PathVariable String year) {
		User user = userRepository.findOne(userId);
		if (user != null) {
			user.getQualification().put(standard, year);
			userRepository.save(user);
			return "Updated";
		} else {
			return "User not found.";
		}
	}
}