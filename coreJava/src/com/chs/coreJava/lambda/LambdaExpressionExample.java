package com.chs.coreJava.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExpressionExample {
	
	public static int outerStaticNum;
    public int outerNum;

	public static void main(String[] args) {
		Drawable drawable = () -> {
			System.out.println("Draw a picture ...");
		};
		
		drawable.draw();
		
		Addable addable = (a, b) -> (a+b);
		System.out.println("Addable : " + addable.add(5, 6));
		
		addable = (int a, int b) -> {
			return a+b;
		};
		System.out.println("Addable: " + addable.add(6, 8));
		
		//Loop
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(23);
		list.forEach(
			(n)-> System.out.println("List: " + n)
		);
		
		//Thread
		Runnable run = () -> {
			System.out.println("Thread is running ...");
		};
		new Thread(run).start();
		
		//Comparator
		String[] strs = {"Hello", "Morning", "Afternoon"};
		//For one line method bodies you can skip both the braces {} and the return keyword
		//The java compiler is aware of the parameter types so you can skip them as well
		Arrays.sort(strs, (a, b)-> a.compareTo(b));
		for(String s : strs) {
			System.out.println(s);
		}
		
		//filter Collection data
		LambdaExpressionExample example = new LambdaExpressionExample();
		List<Product> products = new ArrayList<>();
		products.add(example.new Product(10, "Book"));
		products.add(example.new Product(13, "Pencil"));
		products.add(example.new Product(3, "Ruler"));
		
		products
			.stream()
			.filter(a-> a.price > 9)
			.forEach(System.out::println);
		
		//local variable, should be final or implicitly final.
		int num = 1;//implicitly final, readOnly
		addable = (a, b) -> a+b+num;
		System.out.println(addable.add(1, 2));
		
		//member fields or static variable, we can read/write
		addable = (a, b) -> {
			outerStaticNum = 1;
			example.outerNum = 2;
			return outerStaticNum+example.outerNum+a+b;
		};
		System.out.println(addable.add(1, 2));
		
		Predicate<String> predicate = (s) -> s.length()>0;
		System.out.println(predicate.test("123"));
		Predicate<Boolean> nonNull = Objects::nonNull;
		System.out.println(nonNull.test(null));
	}
	
	class Product{
		public int price;
		public String name;
		
		@Override
		public String toString() {
			return "Product [price=" + price + ", name=" + name + "]";
		}

		public Product(int price, String name) {
			this.price = price;
			this.name = name;
		}
	}
}
