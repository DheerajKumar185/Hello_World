package com.tech.lti.mongodb.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.lti.mongodb.dao.UserDao;
import com.tech.lti.mongodb.dao.UserRepository;
import com.tech.lti.mongodb.exception.ErrorDetails;
import com.tech.lti.mongodb.exception.UserNotFoundException;
import com.tech.lti.mongodb.model.User;

@RestController
public class UserController {

	/*private final Logger logger = LoggerFactory.getLogger(getClass());*/
	private static final Logger logger = LogManager.getLogger();

	private final UserRepository userRepository;

	private final UserDao userDao;

	private ErrorDetails response = null;

	public UserController(UserRepository userRepository, UserDao userDao) {
		this.userRepository = userRepository;
		this.userDao = userDao;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		logger.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<ErrorDetails> getAllUsers() throws Exception {
		logger.info("Getting all users.");

		List<User> users = userRepository.findAll();

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setCode(200);
		errorDetails.setMessage("success");
		errorDetails.setData(users);

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ErrorDetails> getUser(@PathVariable String userId) throws Exception {
		logger.info("Getting user with ID: {}.", userId);
		response = new ErrorDetails();

		User user = userRepository.findOne(userId);

		if (user == null) {
			logger.error("user not found with ID : {}", userId);
			throw new UserNotFoundException(userId);
		}

		response.setCode(200);
		response.setMessage("success");
		response.setData(user);

		return new ResponseEntity<ErrorDetails>(response, HttpStatus.OK);
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