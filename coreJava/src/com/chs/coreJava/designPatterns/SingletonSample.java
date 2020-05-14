package com.chs.coreJava.designPatterns;

public class SingletonSample {
	
	private volatile static SingletonSample singleton;
	
	private SingletonSample() {
	}
	
	public static SingletonSample getInstance() {
		if(singleton == null) {
			synchronized(SingletonSample.class) {
				if(singleton == null) {
					singleton = new SingletonSample();
				}
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		System.out.println(getInstance());
		System.out.println(getInstance());
		
		SingletonWithEnum singleton = SingletonWithEnum.INSTANCE;
		singleton.setName("Thomas");
		
		SingletonWithEnum singleton2 = SingletonWithEnum.INSTANCE;
		singleton2.setName("Thomas2");
		
		System.out.println(singleton.getName());
		System.out.println(singleton);
		System.out.println(singleton2);
	}

}
