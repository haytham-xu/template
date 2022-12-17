package com.haythamxu.controller;
import com.haythamxu.dto.BookDTO;
import com.haythamxu.entity.Book;
import com.haythamxu.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class BookControllerTest {
    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddBook() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Title");
        bookDTO.setAuthor("Author");
        bookDTO.setIsbn("ISBN");
        bookDTO.setPublisher("Publisher");
        bookDTO.setPublicationDate(LocalDate.now());
        bookDTO.setCategory("Category");
        Book existingBook = new Book();
        existingBook.setIsbn("ISBN");
        when(bookService.getBookByIsbn("ISBN")).thenReturn(existingBook);
        ResponseEntity<String> response = bookController.addBook(bookDTO);
        verify(bookService, times(1)).addBook(existingBook);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book added successfully.", response.getBody());
    }
    @Test
    public void testAddNewBook() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Title");
        bookDTO.setAuthor("Author");
        bookDTO.setIsbn("ISBN");
        bookDTO.setPublisher("Publisher");
        bookDTO.setPublicationDate(LocalDate.now());
        bookDTO.setCategory("Category");
        when(bookService.getBookByIsbn("ISBN")).thenReturn(null);
        ResponseEntity<String> response = bookController.addBook(bookDTO);
        verify(bookService, times(1)).addBook(any(Book.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("New Book added.", response.getBody());
    }
    @Test
    public void testSearchBooks() {
        Book book = new Book();
        book.setIsbn("ISBN");
        when(bookService.getBookByIsbn("ISBN")).thenReturn(book);
        ResponseEntity<Book> response = bookController.searchBooks("ISBN");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }
    @Test
    public void testSearchBooksNotFound() {
        when(bookService.getBookByIsbn("ISBN")).thenReturn(null);
        ResponseEntity<Book> response = bookController.searchBooks("ISBN");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookService.getAllBooks()).thenReturn(books);
        ResponseEntity<List<Book>> response = bookController.getAllBooks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
    }
}
