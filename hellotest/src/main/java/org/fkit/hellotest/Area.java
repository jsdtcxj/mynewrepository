package org.fkit.hellotest;

public interface Area {

	default String getLocation() {
		return "China";
	}
}
