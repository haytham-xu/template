package com.haythamxu.service;
import com.haythamxu.entity.Book;
import com.haythamxu.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddBook() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setIsbn("ISBN");
        book.setPublisher("Publisher");
        book.setPublicationDate(LocalDate.now());
        book.setCategory("Category");
        bookService.addBook(book);
        verify(bookRepository, times(1)).save(book);
    }
    @Test
    public void testGetBookByIsbn() {
        String isbn = "ISBN";
        Book book = new Book();
        book.setIsbn(isbn);
        when(bookRepository.findByIsbn(isbn)).thenReturn(book);
        Book result = bookService.getBookByIsbn(isbn);
        assertEquals(book, result);
    }
    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> result = bookService.getAllBooks();
        assertEquals(books, result);
    }
}
