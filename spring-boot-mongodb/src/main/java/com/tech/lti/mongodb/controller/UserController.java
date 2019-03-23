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
import com.tech.lti.mongodb.exception.CustomException;
import com.tech.lti.mongodb.exception.ErrorResponse;
import com.tech.lti.mongodb.exception.UserNotFoundException;
import com.tech.lti.mongodb.model.User;

@RestController
public class UserController {

	/*private final Logger logger = LoggerFactory.getLogger(getClass());*/
	private static final Logger logger = LogManager.getLogger();

	private final UserRepository userRepository;

	private final UserDao userDao;

	private ErrorResponse response = null;

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
	public ResponseEntity<ErrorResponse> getAllUsers() throws CustomException {
		logger.info("Getting all users.");

		List<User> users = null;
		try {
			users = userRepository.findAll();
		} catch (Exception ex) {
			if(ex.getMessage().contains("MongoTimeoutException")) {
				throw new CustomException(HttpStatus.SERVICE_UNAVAILABLE.value(), "Currently mongodb down due to some maintenance activity. Please contact to DB administrative team.", ex.getMessage());
			} else {
				throw new CustomException(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage());
			}
			
		}

		ErrorResponse errorDetails = new ErrorResponse();
		errorDetails.setErrorCode(200);
		errorDetails.setErrorMessage("success");
		errorDetails.setData(users);

		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ErrorResponse> getUser(@PathVariable String userId) throws Exception {
		logger.info("Getting user with ID: {}.", userId);
		response = new ErrorResponse();

		User user = userRepository.findOne(userId);

		if (user == null) {
			logger.error("user not found with ID : {}", userId);
			throw new UserNotFoundException(userId);
		}

		response.setErrorCode(200);
		response.setErrorMessage("success");
		response.setData(user);

		return new ResponseEntity<ErrorResponse>(response, HttpStatus.OK);
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