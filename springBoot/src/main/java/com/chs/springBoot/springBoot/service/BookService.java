package com.chs.springBoot.springBoot.service;

import java.util.List;

import com.chs.springBoot.springBoot.entity.Book;

public interface BookService {
	
	void save(Book book);
	
	List<Book> findByName(String name);
	
	List<Book> getBookByAuthor(String name);
}
