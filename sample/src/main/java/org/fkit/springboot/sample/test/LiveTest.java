package org.fkit.springboot.sample.test;

import javax.xml.ws.Response;

import org.fkit.springboot.sample.App;
import org.fkit.springboot.sample.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {App.class}, webEnvironment=WebEnvironment.DEFINED_PORT)
public class LiveTest {
	private static final String API_ROOT = "http://localhost:8081/api/books";
	
	private Book createRandomBook() {
		Book book = new Book();
		book.setAuthor("Tom");
		book.setTitle("Book1");
		return book;
	}
	
}
