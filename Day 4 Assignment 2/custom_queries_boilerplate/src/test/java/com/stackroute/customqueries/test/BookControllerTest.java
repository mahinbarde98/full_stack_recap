package com.stackroute.customqueries.test;

import com.stackroute.customqueries.controller.BookController;
import com.stackroute.customqueries.model.Book;
import com.stackroute.customqueries.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private List<Book> testBookList;

    @Before
    public void setUp() {
        Book book1 = new Book(1L, "Book1", "Author1", 2000);
        Book book2 = new Book(2L, "Book2", "Author2", 2010);
        testBookList = Arrays.asList(book1, book2);
    }

    @Test
    public void testGetBooksPublishedAfterYear() {
        when(bookService.findBooksPublishedAfterYear(2005)).thenReturn(testBookList);

        ResponseEntity<List<Book>> responseEntity = bookController.getBooksPublishedAfterYear(2005);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void testGetBooksPublishedAfterYearNoResult() {
        when(bookService.findBooksPublishedAfterYear(anyInt())).thenReturn(Arrays.asList());

        ResponseEntity<List<Book>> responseEntity = bookController.getBooksPublishedAfterYear(2025);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(0, responseEntity.getBody().size());
    }
}

