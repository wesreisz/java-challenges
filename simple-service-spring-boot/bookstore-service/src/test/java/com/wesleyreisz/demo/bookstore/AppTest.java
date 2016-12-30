package com.wesleyreisz.demo.bookstore;

import com.wesleyreisz.demo.bookstore.book.model.Author;
import com.wesleyreisz.demo.bookstore.book.model.Book;
import com.wesleyreisz.demo.bookstore.book.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */

public class AppTest {
    BookService service;

    @Before
    public void initialize() {
        service = null;
        service = BookService.getInstance();
    }

    @Test
    public void getListTest(){
        List<Book> bookList = service.getAll();
        Assert.assertNotNull(bookList);
        Assert.assertEquals(3, bookList.size());
    }

    @Test
    public void addBookTest(){
        String bookISN = "b123";
        Book newBook = new Book(bookISN,"New Test Book",new Author(11,"Joe","Jones","joe@jones.com"),new Date());
        service.addUpdateBook(newBook);

        Book addedBook = service.findByISBN(bookISN);
        Assert.assertEquals(newBook.toString().hashCode(),addedBook.toString().hashCode());
    }

    @Test
    public void removeBookTest(){
        List<Book> bookList = service.getAll();
        Assert.assertEquals(3, bookList.size());
        Book oldBook = new Book("A123","War and Peace", new Author(1,"Leonardo","Tolstoy","wes@wesleyreisz.com"),new Date());
        service.removeBook(oldBook);
        Assert.assertEquals(2, bookList.size());
    }

    @Test
    public void getBookTest(){
        Book book = service.findByISBN("A123");

        Assert.assertNotNull(book.getIsbn());
        Assert.assertNotNull(book.getAuthor());
        Assert.assertNotNull(book.getAuthor().getEmail());
    }

    @Test
    public void updateBookTest(){
        String testISBN = "A123";

        int originalHashCode = service.findByISBN(testISBN).toString().hashCode();
        Book updatedBook = service.findByISBN(testISBN);

        Assert.assertEquals(originalHashCode,updatedBook.toString().hashCode());

        updatedBook.setName("My New Book");
        Author updatedAuthor = updatedBook.getAuthor();
        updatedAuthor.setFirstName("Wes");
        updatedAuthor.setEmail("wes@wesleyreisz.com");
        updatedBook.setAuthor(updatedAuthor);

        service.updateBook(updatedBook);

        Book testBook = service.findByISBN(testISBN);
        Assert.assertNotEquals(originalHashCode,testBook.toString().hashCode());
    }

}
