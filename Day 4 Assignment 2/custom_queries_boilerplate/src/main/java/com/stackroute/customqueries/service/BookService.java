package com.stackroute.customqueries.service;

import com.stackroute.customqueries.model.Book;
import com.stackroute.customqueries.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //return required data using the custom query method from the repository
    public List<Book> findBooksPublishedAfterYear(int year) {
        List<Book> books = bookRepository.findBooksPublishedAfterYear(year);

        return books;
    }
}

