package com.haythamxu.repository;
import com.haythamxu.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    public void testFindAll() {
        // Create some test books
        Book book1 = new Book();
        book1.setTitle("Title 1");
        book1.setAuthor("Author 1");
        book1.setIsbn("ISBN 1");
        book1.setPublisher("Publisher 1");
        book1.setPublicationDate(LocalDate.now());
        book1.setCategory("Category 1");
        Book book2 = new Book();
        book2.setTitle("Title 2");
        book2.setAuthor("Author 2");
        book2.setIsbn("ISBN 2");
        book2.setPublisher("Publisher 2");
        book2.setPublicationDate(LocalDate.now());
        book2.setCategory("Category 2");
        // Save the books to the repository
        bookRepository.save(book1);
        bookRepository.save(book2);
        // Retrieve all books from the repository
        List<Book> books = bookRepository.findAll();
        // Check that the books were retrieved successfully
        assertNotNull(books);
        assertEquals(2, books.size());
    }
    @Test
    public void testFindByIsbn() {
        // Create a test book
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setIsbn("ISBN");
        book.setPublisher("Publisher");
        book.setPublicationDate(LocalDate.now());
        book.setCategory("Category");
        // Save the book to the repository
        bookRepository.save(book);
        // Retrieve the book by its ISBN
        Book retrievedBook = bookRepository.findByIsbn("ISBN");
        // Check that the book was retrieved successfully
        assertNotNull(retrievedBook);
        assertEquals("Title", retrievedBook.getTitle());
        assertEquals("Author", retrievedBook.getAuthor());
        assertEquals("ISBN", retrievedBook.getIsbn());
        assertEquals("Publisher", retrievedBook.getPublisher());
        assertEquals(LocalDate.now(), retrievedBook.getPublicationDate());
        assertEquals("Category", retrievedBook.getCategory());
    }
}
