package com.stackroute.customqueries.repository;

import com.stackroute.customqueries.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //write a custom query to find books published after a certain year
    @Query("SELECT b FROM Book b WHERE b.publishedYear > : year")
    List<Book> findBooksPublishedAfterYear(@Param("year") int year);
}
