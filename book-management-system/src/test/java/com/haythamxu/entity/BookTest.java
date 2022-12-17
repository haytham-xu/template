package com.haythamxu.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    @Test
    public void testQuantityIncrease() {
        // Create a book object
        Book book = new Book();
        book.setQuantityInStock(0);
        // Increase the quantity
        book.quantityIncrease();
        // Check that the quantity has increased by 1
        assertEquals(1, book.getQuantityInStock());
    }
}
