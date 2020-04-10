package com.ge.re.sdm.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ge.re.sdm.model.Book;
import com.ge.re.sdm.service.BookServiceImpl;

/* This is Rest controller invoked for Book CURD operations */
@RestController
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;

	/* This method invokes Business service class to get list of books */
    @GetMapping(path = "/books")
public List<Book> books()
{
	
    	List<Book> listofBooks = bookService.ListofBooks();
    	return listofBooks;
}
    /* This method invokes Business service class to get book based on Book ID  */
    @GetMapping("/books/{id}")
public Optional<Book> retreiveBookById(@PathVariable Long id)

{
    	Optional<Book> book = bookService.findBookById(id);
    	  return book;
}
    /* This method This method invokes Business service class to deletes book based on  Book ID  */
    @DeleteMapping("/books/{id}")
public void deleteBook(@PathVariable Long id)
{
    	bookService.DeleteBookById(id);
}
    /*This method invokes Business service class to creating new book  */
@PostMapping("/books")
public ResponseEntity<Object> createBook(@Valid @RequestBody Book book) {
	Book newBook = bookService.saveBook(book);

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newBook.getId())
			.toUri();

	return ResponseEntity.created(location).build();

}




}
