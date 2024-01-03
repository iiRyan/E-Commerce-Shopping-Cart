package com.ecommerce.helper;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {
	
	
	
	public static String hashedPassword(String password) {

		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

		return hashedPassword;
	}

	public static boolean decrypt(String userInput, String storedPassword) {
		return BCrypt.checkpw(userInput, storedPassword);

	}

}