package com.haythamxu.dto;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BookDTOTest {
    @Test
    public void testGettersAndSetters() {
        // Create a BookDTO object
        BookDTO bookDTO = new BookDTO();
        // Set values using setters
        bookDTO.setTitle("Title");
        bookDTO.setAuthor("Author");
        bookDTO.setIsbn("ISBN");
        bookDTO.setPublisher("Publisher");
        bookDTO.setPublicationDate(LocalDate.now());
        bookDTO.setCategory("Category");
        // Use getters to retrieve values and assert
        assertEquals("Title", bookDTO.getTitle());
        assertEquals("Author", bookDTO.getAuthor());
        assertEquals("ISBN", bookDTO.getIsbn());
        assertEquals("Publisher", bookDTO.getPublisher());
        assertEquals(LocalDate.now(), bookDTO.getPublicationDate());
        assertEquals("Category", bookDTO.getCategory());
    }
}
