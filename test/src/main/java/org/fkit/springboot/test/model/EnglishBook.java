package org.fkit.springboot.test.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EnglishBook implements ApplicationContextAware, BeanNameAware{
	
	private ApplicationContext context;
	
	private String story;
	
	private String username;
	
	private String beanName;
	
//	public EnglishBook() {
//		System.out.println("Initialize EnglishBook ...");
//	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
		System.out.println("populate context: " + context.toString());
	}

	public void readBook(String name) {
		System.out.println("Load username from jdbc.properties: " + username);
		System.out.println("Reading book " + name + " ...");
		System.out.println("The story is : " + getStory());
	}
	
	public void initBook() {
		System.out.println("do setup beforing use book ...");
	}
	
	public void destroyBook() {
		System.out.println("release Resource ...");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		context = applicationContext;
		System.out.println("populate context2: " + context.toString());
	}

	@Override
	public void setBeanName(String name) {
		beanName = name;
		System.out.println("Bean name: " + name);
	}
	
	public String getBeanName() {
		return beanName;
	}
}
