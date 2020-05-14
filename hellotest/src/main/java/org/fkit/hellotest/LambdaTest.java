package org.fkit.hellotest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {
	
	class Person {
		private String name;
		private int age;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public <COL extends List<Person>> void test(Predicate<Person> predicate, 
			Consumer<String> consumer, 
			Function<Person, String> function,
			Supplier<COL> supplier) {
		
		COL list = supplier.get();
		for(Person p : list) {
			if(predicate.test(p)) {
				String name = function.apply(p);
				consumer.accept(name);
			}
		}
		
	}
	
	public List<Person> init() {
		List<Person> list = new ArrayList<Person>();
		Person p = new Person();
		p.setAge(21);
		p.setName("Tom");
		list.add(p);
		
		
		return list;
	}

	public static void main(String[] args) {
		LambdaTest test = new LambdaTest();
		test.test((Person p) -> p.getAge() > 20, 
				name -> System.out.println("Person Name is " + name)
				, p -> p.getName(),
				test::init);
		
	}
}
