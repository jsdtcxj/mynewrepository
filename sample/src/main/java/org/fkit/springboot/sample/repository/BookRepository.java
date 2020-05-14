package org.fkit.springboot.sample.repository;

import java.util.List;

import org.fkit.springboot.sample.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByTitle(String title);
}
