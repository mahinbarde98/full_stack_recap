package com.stackroute.customqueries.test;

import com.stackroute.customqueries.model.Book;
import com.stackroute.customqueries.repository.BookRepository;
import com.stackroute.customqueries.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindBooksPublishedAfterYear() {
        Book book1 = new Book( "Book1", "Author1", 2000);
        Book book2 = new Book( "Book2", "Author2", 2010);
        List<Book> expectedBooks = Arrays.asList(book2);
        when(bookRepository.findBooksPublishedAfterYear(anyInt())).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findBooksPublishedAfterYear(2005);

        assertEquals(1, actualBooks.size());
        assertEquals("Book2", actualBooks.get(0).getTitle());
    }

    @Test
    public void testFindBooksPublishedAfterYearNoResult() {
        when(bookRepository.findBooksPublishedAfterYear(anyInt())).thenReturn(Arrays.asList());

        List<Book> actualBooks = bookService.findBooksPublishedAfterYear(2025);

        assertEquals(0, actualBooks.size());
    }

    @Test
    public void testFindBooksPublishedAfterInvalidYear() {
        when(bookRepository.findBooksPublishedAfterYear(anyInt())).thenThrow(IllegalArgumentException.class);

        try {
            bookService.findBooksPublishedAfterYear(-100);
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
}

