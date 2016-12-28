package com.wesleyreisz.demo.bookstore;

import com.wesleyreisz.demo.bookstore.book.model.Author;
import com.wesleyreisz.demo.bookstore.book.model.Book;
import com.wesleyreisz.demo.bookstore.book.BookService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */

public class AppTest {
    @Test
    public void getListTest(){
        BookService service = new BookService();

        List<Book> bookList = service.getAll();
        Assert.assertNotNull(bookList);
        Assert.assertEquals(3, bookList.size());
    }

    @Test
    public void addBookTest(){
        BookService service = new BookService();

        List<Book> bookList = service.getAll();
        Assert.assertEquals(3, bookList.size());
        Book newBook = new Book("b123","New Test Book",new Author(11,"Joe","Jones","joe@jones.com"),new Date());
        service.addBook(newBook);
        Assert.assertEquals(4, bookList.size());
    }

    @Test
    public void removeBookTest(){
        BookService service = new BookService();

        List<Book> bookList = service.getAll();
        Assert.assertEquals(3, bookList.size());
        Book oldBook = new Book("A123","War and Peace", new Author(1,"Leonardo","Tolstoy","wes@wesleyreisz.com"),new Date());
        service.removeBook(oldBook);
        Assert.assertEquals(2, bookList.size());
    }

    @Test
    public void getBookTest(){
        BookService service = new BookService();
        Book book = service.findByISBN("A123");
        Assert.assertEquals("Leonardo",book.getAuthorName().getFirstName());
        Assert.assertEquals("A123",book.getIsbn());
        Assert.assertEquals("War and Peace", book.getName());
    }
}
