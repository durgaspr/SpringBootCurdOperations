package com.ge.re.sdm.service;

import java.util.List;
import java.util.Optional;
import com.ge.re.sdm.model.Book;
/* This interface provides abstract level for service level methods */
public interface BookService {
 
	public List<Book> ListofBooks();
	
	public Optional<Book> findBookById(Long id);
	
	public void DeleteBookById(Long id);

	
    public Book saveBook(Book book);
	
}
