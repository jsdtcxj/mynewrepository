package com.chs.coreJava.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Tom");
		list.add("Jack");
		list.add("Chris");
		
		ListIterator<String> it = list.listIterator();
		System.out.println("Traverse forward ...");
		while(it.hasNext()) {
			String name = it.next();
			if(name.equals("Jack")) {
				it.remove();
			} else {
				System.out.println(name);
			}
		}
		it.add("James");
		
		System.out.println("Traverse backward ...");
		while(it.hasPrevious()) {
			String name = it.previous();
			if(name.equals("Chris")) {
				it.set(name.toUpperCase());
				name = list.get(1);
			} 
			
			System.out.println(name);
		}
		
	}

}
