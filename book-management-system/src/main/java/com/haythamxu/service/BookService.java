package com.haythamxu.service;

import com.haythamxu.entity.Book;
import com.haythamxu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing books.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Constructor-based dependency injection with autowiring.
     *
     * @param bookRepository the book repository to be injected.
     */
    @Autowired
    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Adds a book to the repository.
     *
     * @param book the book to be added.
     */
    public void addBook(final Book book) {
        this.bookRepository.save(book);
    }

    /**
     * Retrieves a book by its ISBN.
     *
     * @param isbn the ISBN of the book.
     * @return the book, if found.
     */
    public Book getBookByIsbn(final String isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

    /**
     * Retrieves all books from the repository.
     *
     * @return a list of all books.
     */
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }
}
