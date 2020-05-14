package org.fkit.hellotest;

public interface Pet {

	int getPrice();
	
	default String getName() {
		return "Pet";
	}
}
