package com.backend.encryption.passwordencryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.encryption.passwordencryption.delegate.PasswordHash;
import com.backend.encryption.passwordencryption.domain.UserDetailsInput;
import com.backend.encryption.passwordencryption.domain.UserDetailsOutput;

@RestController
@RequestMapping("/encode")
public class PasswordEncryptionController {
	
	@Autowired
	PasswordHash passwordHash;
	
	@PostMapping(path="/pwd", consumes= "application/json", produces="application/json")
	public ResponseEntity<UserDetailsOutput> generateEncryptedPassword(@RequestBody UserDetailsInput userDetailsInput){
		return new ResponseEntity<UserDetailsOutput>(passwordHash.createEncryptPassword(userDetailsInput), 
																HttpStatus.OK);
	}

}
