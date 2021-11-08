package com.besugeytech.collectionsmodule.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.besugeytech.collectionsmodule.exceptions.BesugeyAuthenticationException;
import com.besugeytech.collectionsmodule.model.CollectionUserDetails;

@RestController
public class AuthenticationController {
	
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationController.class);
	
	@GetMapping("/hello")
	public String hello(){
		LOGGER.info("Executing restendpoint /hello");
		return "Welcome to Besugey Tech Collections Module";
	}
	
	@PostMapping(value="/authenticateuser")
	public ResponseEntity<CollectionUserDetails> authenticateUser(@RequestBody CollectionUserDetails user) throws BesugeyAuthenticationException{
		
		String userId = user.getUserId();
		String password = user.getPassword();
		CollectionUserDetails authenticatedUser = null;
		
		if(userId.equals("User") && password.equals("Pass")){
			authenticatedUser = new CollectionUserDetails();
			authenticatedUser.setUserRole("Manager");
			authenticatedUser.setUserId("User");
			return new ResponseEntity<CollectionUserDetails>(authenticatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity(new BesugeyAuthenticationException().getMessage(), HttpStatus.FORBIDDEN);
		}
		
		
		
		//return authenticatedUser;
	}

}
