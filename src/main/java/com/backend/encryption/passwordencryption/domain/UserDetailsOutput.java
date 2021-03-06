package com.backend.encryption.passwordencryption.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDetailsOutput {
	
	private String username;
	private String encryptedPassword;

}
