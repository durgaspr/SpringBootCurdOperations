package com.ge.re.sdm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.re.sdm.model.Book;
/* This interface get the features curd operations features by extending JpaRepository interface */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	

}
