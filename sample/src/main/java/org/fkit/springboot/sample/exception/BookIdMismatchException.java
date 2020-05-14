package org.fkit.springboot.sample.exception;

public class BookIdMismatchException extends RuntimeException{

	public BookIdMismatchException() {
		super();
	}
	
	public BookIdMismatchException(String message, Throwable cause) {
		super(message, cause);
	}
}
