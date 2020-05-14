package org.fkit.hellotest;

import java.lang.reflect.Field;

@JasonSerializable
public class Person {
	public String name;
	
	@JasonElement(key = "Hello!")
	public String key;
	
	public static void main(String[] args) {
		Person p = new Person();
		assert (p.name == null) : "name is null";
			
		Class clazz = p.getClass();
		if(clazz.isAnnotationPresent(JasonSerializable.class)) {
			for(Field f : clazz.getFields()) {
				if(f.isAnnotationPresent(JasonElement.class)) {
					JasonElement e = f.getAnnotation(JasonElement.class);
					System.out.println(e.key());
				}
			}
		}
		
		try(MyResource r = new MyResource()) {
			r.print1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
