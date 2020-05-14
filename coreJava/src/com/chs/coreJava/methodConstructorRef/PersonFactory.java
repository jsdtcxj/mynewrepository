package com.chs.coreJava.methodConstructorRef;

public interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}
