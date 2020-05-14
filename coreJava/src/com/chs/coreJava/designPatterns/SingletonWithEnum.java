package com.chs.coreJava.designPatterns;

public enum SingletonWithEnum {
	INSTANCE;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
