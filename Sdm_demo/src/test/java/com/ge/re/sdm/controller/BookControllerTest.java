package com.ge.re.sdm.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.ge.re.sdm.model.Book;
import com.ge.re.sdm.service.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
/* Performing Junit tests for controller layer */
class BookControllerTest {

	@InjectMocks
   BookController bookController;
     
    @Mock
    BookServiceImpl bookservice;
    /* unit testing for  creating new resource */
    @Test
    public void testcreateBook()
    {
    	MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Book book = new Book(1,"Spring cloud", new Date());
        when(bookservice.saveBook(any(Book.class))).thenReturn(book);
       
        ResponseEntity<Object> responseEntity = bookController.createBook(book);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
    
    /* unit testing for getting all resources */
   @Test
    public void test_books() 
    {
        // given
        Book firstBook = new Book(1,"spring",new Date());
        Book secondBook = new Book(2,"cloud",new Date());
      
        List<Book> booksList = new ArrayList<Book>();
		booksList.add(firstBook);
		booksList.add(secondBook);
		when(bookservice.ListofBooks()).thenReturn(booksList);
		
		List<Book> books = bookController.books();
				assertThat(books.size()).isEqualTo(2);
		         
		        assertThat(books.get(0).getName())
		                        .isEqualTo(firstBook.getName());
		         
		        assertThat(books.get(1).getName())
		                        .isEqualTo(secondBook.getName());
    }
    
    
}
