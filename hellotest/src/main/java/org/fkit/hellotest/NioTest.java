package org.fkit.hellotest;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioTest {
	public static void main(String[] args) {
		Path path = Paths.get("/Users/xiaojin/../Downloads");
		
		System.out.println(path.getNameCount());
		System.out.println(path);
		
		System.out.println(path.normalize());
		
		String home = System.getProperty("user.home");
		path = Paths.get(home);
		System.out.println(path);
		
		System.out.println(path.resolve("java"));
		
		Path p1 = Paths.get("book");
		Path p2 = Paths.get("Student");
		System.out.println(p1.relativize(p2));
		
		int[] index = new int[128];
		for(int i = 0; i < index.length; i++) {
			index[i] = i;
		}
		
		System.out.println(index['A']);
		System.out.println(Character.toString((char)index['A']));
	}
}
