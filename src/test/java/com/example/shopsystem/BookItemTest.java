package com.example.shopsystem;

import com.example.shopsystem.storeItems.BookItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookItemTest {
    private BookItem bookItem;

    @BeforeEach
    public void setUp() {
        bookItem = new BookItem(1, "Test Book", 100.0, "Test Author");
    }

    /**
     * test method for com.example.shopsystem.storeItems.BookItem.getTypeDependantString()
     * testing to see if the type dependant string returns the correct string
     */
    @Test
    public void testGetTypeDependantString() {
        assertEquals("Test Author", bookItem.getTypeDependantString(), "getTypeDependantString should return the author");
    }

    /**
     * test method for com.example.shopsystem.storeItems.BookItem.getAuthor()
     * testing to see if it returns the correct author
     */
    @Test
    public void testGetAuthor() {
        assertEquals("Test Author", bookItem.getAuthor(), "getAuthor should return the correct author");
    }
}
