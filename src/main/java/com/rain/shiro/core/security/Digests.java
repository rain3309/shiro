package com.rain.shiro.core.security;

import java.security.SecureRandom;

import org.apache.commons.lang3.Validate;

public class Digests {

	private static SecureRandom random = new SecureRandom();
	
	public static byte[] generateSalt(int numBytes) {
		//Validate.isTrue(numBytes > 0, "numBytes 长度必须大于 0", numBytes);
		byte [] bytes = new byte[numBytes];
		random.nextBytes(bytes);;
		return bytes;
	}
	
}
