package com.haythamxu.controller;

import com.haythamxu.dto.BookDTO;
import com.haythamxu.entity.Book;
import com.haythamxu.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    @Setter
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody final BookDTO bookDTO) {
        final Book existingBook = bookService.getBookByIsbn(bookDTO.getIsbn());
        if(existingBook == null) {
            final Book newBook = new Book();
            newBook.setAuthor(bookDTO.getAuthor());
            newBook.setIsbn(bookDTO.getIsbn());
            newBook.setPublisher(bookDTO.getPublisher());
            newBook.setPublicationDate(bookDTO.getPublicationDate());
            newBook.setCategory(bookDTO.getCategory());
            newBook.setTitle(bookDTO.getTitle());
            newBook.setQuantityInStock(1);
            this.bookService.addBook(newBook);
            return ResponseEntity.ok("New Book added.");
        }
        existingBook.quantityIncrease();
        this.bookService.addBook(existingBook);
        new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return ResponseEntity.ok("Book added successfully.");
    }

    @GetMapping("/search/{isbn}")
    public ResponseEntity<Book> searchBooks(@PathVariable final String isbn) {
        final Book book = bookService.getBookByIsbn(isbn);
        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // get current timestamp.
        final long currentTime = System.currentTimeMillis();

        return ResponseEntity.ok(book);
    }

    // q:hi
    // delete a book by isbn.
    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable final String isbn) {
        final Book book = bookService.getBookByIsbn(isbn);
        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.bookService.deleteBook(book);
        return ResponseEntity.ok("Book deleted successfully.");
    }
}
