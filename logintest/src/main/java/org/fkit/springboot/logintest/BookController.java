package org.fkit.springboot.logintest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@RequestMapping("/findBook")
	public Book findBook(@RequestBody Book book) {
		System.out.println(book);
		
		book.setAuthor("Thomas");
		book.setName("Jackson");
		book.setPrice(200.19);
		return book;
	}
	
	@RequestMapping("/findBooks")
	public List<Book> findBooks() {
		System.out.println("invoke findBooks");
		List<Book> list = new ArrayList<Book>();
		
		list.add(new Book(1, "Ali", "Cat", 101.00));
		list.add(new Book(2, "James", "Dog", 202.101));
		list.add(new Book(3, "Thomas", "Pig", 202.12));
		return list;
	}
}
