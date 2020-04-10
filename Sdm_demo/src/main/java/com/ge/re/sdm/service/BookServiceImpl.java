package com.ge.re.sdm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.re.sdm.Exception.BookNotFoundException;
import com.ge.re.sdm.Repository.BookRepository;
import com.ge.re.sdm.model.Book;

@Service
/* This BookServiceImpl class implements our complete business logic for Book CURD operations */
public class BookServiceImpl implements BookService {
@Autowired
	private BookRepository bookRepository;
	public List<Book> ListofBooks() {
		
		 List<Book> bookList = bookRepository.findAll();
		return bookList;
	
	       }
	 /*This method invokes BookRepository interface to find new book  */
	public Optional<Book> findBookById(Long id) 
	{
		Optional<Book> book = bookRepository.findById(id);
		
		if (!book.isPresent())
			throw new BookNotFoundException("No Book found for given id" + id);
        return book;
           
        } 
	 /*This method invokes BookRepository interface to delete book basd on provided id */
	public void DeleteBookById(Long id) 
	
	{
		Optional<Book> bookEntity = bookRepository.findById(id);
		
		if (!bookEntity.isPresent())
			throw new BookNotFoundException("id-" + id);

		bookRepository.deleteById(id);
		//bookRepository.delete
		
	}

	 /*This method invokes BookRepository interface to find new book  */
	public Book saveBook(Book book) {
		
		return bookRepository.save(book);

		

		
	}

	

	

}
