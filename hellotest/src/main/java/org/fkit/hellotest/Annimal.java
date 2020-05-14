package org.fkit.hellotest;

public interface Annimal {

	String getColor();
	
	default String getName() {
		return "Annimal";
	}
}
