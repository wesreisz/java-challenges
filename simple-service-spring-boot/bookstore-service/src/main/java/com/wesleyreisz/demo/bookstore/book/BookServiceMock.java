package com.wesleyreisz.demo.bookstore.book;

import com.wesleyreisz.demo.bookstore.book.model.Author;
import com.wesleyreisz.demo.bookstore.book.model.Book;
import com.wesleyreisz.demo.bookstore.book.model.ServiceResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wesleyreisz on 12/28/16.
 */
@Service
public class BookServiceMock {
    private static List<Book> bookList = null;

    public BookServiceMock(){
        if (ObjectUtils.isEmpty(bookList)){
            bookList = new ArrayList<>();

            bookList.add(new Book("A123","War and Peace", new Author(1,"Leonardo","Tolstoy","wes@wesleyreisz.com"),new Date()));
            bookList.add(new Book("A124","Card Chronicles", new Author(2,"Matt","Mathews","wes@wesleyreisz.com"),new Date()));
            bookList.add(new Book("A125","Shogun", new Author(3,"James","Clavel","wes@wesleyreisz.com"),new Date()));
        }
    }

    public List<Book> getAll(){
        return bookList;
    }
    public Book findByISBN(String isbn){
        if (StringUtils.isEmpty(isbn)){
            return new Book();
        }

        for(Book book : bookList){
            if (isbn.equalsIgnoreCase(book.getIsbn())){
                return book;
            }
        }

        return new Book();
    }
    public Book addUpdateBook(Book book){
        if (StringUtils.isEmpty(book)){
            return null;
        }

        if (doesPreviousIsbnExist(book)){
            updateBook(book);
        }else{
            addBook(book);
        }

        return findByISBN(book.getIsbn());
    }

    public Book addBook(Book book){
        if (StringUtils.isEmpty(book)){
            return null;
        }

        //no book in list, add it
        bookList.add(book);
        return findByISBN(book.getIsbn());
    }

    public Book updateBook(Book book){
        if(StringUtils.isEmpty(book.getIsbn())){ //if isbn doesn't have a value return
            return null;
        }

        removeBook(book);
        addUpdateBook(book);
        return findByISBN(book.getIsbn());
    }

    public ServiceResponse removeBook(Book book2remove){
        if (StringUtils.isEmpty(book2remove)){
            return new ServiceResponse(String.format("Book with isbn: %s not found", book2remove.getIsbn()));
        }
        for(int i = 0; i <bookList.size();i++){
            if (bookList.get(i).getIsbn().equalsIgnoreCase(book2remove.getIsbn())){
                bookList.remove(i);
                return new ServiceResponse(String.format("Book with isbn: %s removed", book2remove.getIsbn()));
            }
        }

        return new ServiceResponse(String.format("Book with isbn: %s not found", book2remove.getIsbn()));
    }

    private boolean doesPreviousIsbnExist(Book book) {
        if(StringUtils.isEmpty(book)){
            return false;
        }

        for (Book bookItem : bookList){
            if (bookItem.getIsbn().equalsIgnoreCase(book.getIsbn())){
                return true;
            }
        }
        return false;
    }

}
