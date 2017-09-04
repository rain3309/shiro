package com.rain.shiro.common.exception;

public class Exceptions {
	
	public static RuntimeException unchecked(Exception e) {
		if(e instanceof RuntimeException) {
			return (RuntimeException)e;
		}else {
			return new RuntimeException();
		}
	}

}
