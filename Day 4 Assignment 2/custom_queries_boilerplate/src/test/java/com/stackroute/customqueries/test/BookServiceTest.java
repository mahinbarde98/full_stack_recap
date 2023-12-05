package com.stackroute.customqueries.test;

import com.stackroute.customqueries.model.Book;
import com.stackroute.customqueries.repository.BookRepository;
import com.stackroute.customqueries.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private List<Book> testBookList;

    @Before
    public void setUp() {
        Book book1 = new Book(1L, "Book1", "Author1", 2000);
        Book book2 = new Book(2L, "Book2", "Author2", 2010);
        testBookList = Arrays.asList(book1, book2);
    }

    @Test
    public void testFindBooksPublishedAfterYear() {
        Mockito.when(bookRepository.findBooksPublishedAfterYear(2005)).thenReturn(testBookList);

        List<Book> result = bookService.findBooksPublishedAfterYear(2005);

        assertEquals(2, result.size());
        assertEquals("Book1", result.get(0).getTitle());
        assertEquals("Book2", result.get(1).getTitle());
    }

    @Test
    public void testFindBooksPublishedAfterYearNoResult() {
        Mockito.when(bookRepository.findBooksPublishedAfterYear(anyInt())).thenReturn(Arrays.asList());

        List<Book> result = bookService.findBooksPublishedAfterYear(2025);

        assertEquals(0, result.size());
    }
}
