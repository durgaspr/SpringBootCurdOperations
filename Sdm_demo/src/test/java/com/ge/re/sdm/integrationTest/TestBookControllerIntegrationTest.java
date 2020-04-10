package com.ge.re.sdm.integrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.ge.re.sdm.SdmDemoApplication;
import com.ge.re.sdm.model.Book;
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = SdmDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)

/* Class explains about Integration test */
public class TestBookControllerIntegrationTest {

	@LocalServerPort
    private int port;
 
	/* Integration test for creating new resource */
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testAddBook() {
        Book book = new Book(1,"spring5",new Date());
        ResponseEntity<String> responseEntity = this.restTemplate
        		.postForEntity("http://localhost:" + port + "/books", book, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
  
}


