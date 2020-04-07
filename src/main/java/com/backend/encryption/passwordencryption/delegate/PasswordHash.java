package com.backend.encryption.passwordencryption.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.encryption.passwordencryption.argon2.Argon2PasswordHashing;
import com.backend.encryption.passwordencryption.domain.UserDetailsInput;
import com.backend.encryption.passwordencryption.domain.UserDetailsOutput;

@Service
public class PasswordHash {
	
	@Autowired
	UserDetailsInput userDetailsInput;
	
	@Autowired
	UserDetailsOutput userDetailsOutput;
	
	@Autowired
	Argon2PasswordHashing argon2PasswordHashing;
	
	public UserDetailsOutput createEncryptPassword(UserDetailsInput userDetailsInput) {
		String userName = userDetailsInput.getUsername();
		String rawPassword = userDetailsInput.getPassword();
		char[] rawPasswordChar = rawPassword.toCharArray();
		String passwordHash = argon2PasswordHashing.hashPassword(rawPasswordChar);
		
		userDetailsOutput.setUsername(userName);
		userDetailsOutput.setEncryptedPassword(passwordHash);
		
		return userDetailsOutput;
	}

}
