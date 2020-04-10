package com.ge.re.sdm.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ge.re.sdm.Repository.BookRepository;
import com.ge.re.sdm.model.Book;

/* unit testing for  Service Layer */
public class TestBookServiceImpl {

	@InjectMocks
	BookServiceImpl serviceImpl;
     
    @Mock
    BookRepository bookRepository;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    /* unit testing for getting resources from DB */
    @Test
    public void getAllBooksTest() {
		
    	 List<Book> list = new ArrayList<Book>();
    	 Book FirstBook = new Book(10001,"Spring",new Date());
    	 Book SecondBook = new Book(10002, "Hibernate",new Date() );
    	 Book ThirdBook = new Book(10003, "Core_java", new Date());
    	 list.add(FirstBook);
         list.add(SecondBook);
         list.add(ThirdBook);
    	 when (bookRepository.findAll()).thenReturn(list);
    	 List<Book> listofBooks = serviceImpl.ListofBooks();
         
    	 assertEquals(3, listofBooks.size());
         verify(bookRepository, times(1)).findAll();
          
		
}
    
    /* unit testing for adding resources to DB */
    @Test
    public void createNewBook()
    {
    	Book FirstBook = new Book(10001,"Spring",new Date());
    	serviceImpl.saveBook(FirstBook);
    	verify(bookRepository, times(1)).save(FirstBook);
    	
    }
    
    }