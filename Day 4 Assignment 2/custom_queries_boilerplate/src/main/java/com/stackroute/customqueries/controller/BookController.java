package com.stackroute.customqueries.controller;

import com.stackroute.customqueries.model.Book;
import com.stackroute.customqueries.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // return response entity with required data
    @GetMapping("/publishedAfter/{year}")
    public ResponseEntity<List<Book>> getBooksPublishedAfterYear(@PathVariable int year) {
       List<Book> books =  bookService.findBooksPublishedAfterYear(year);

        return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
    }
}
