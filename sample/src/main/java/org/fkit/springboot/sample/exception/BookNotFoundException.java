package org.fkit.springboot.sample.exception;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BookNotFoundException() {
		super();
	}
}
