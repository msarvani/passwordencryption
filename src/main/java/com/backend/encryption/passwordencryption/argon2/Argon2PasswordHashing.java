package com.backend.encryption.passwordencryption.argon2;

import org.springframework.stereotype.Component;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

@Component
public class Argon2PasswordHashing {

	public String hashPassword(char[] password) {

		Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
		String hashPassword = argon2.hash(4, 1024 * 1024, 8, password);
		boolean success = argon2.verify(hashPassword, "jidjfi**(".toCharArray());
		return hashPassword;
	}
}
