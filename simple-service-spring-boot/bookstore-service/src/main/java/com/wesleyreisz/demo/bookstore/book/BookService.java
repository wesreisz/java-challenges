package com.wesleyreisz.demo.bookstore.book;

import com.wesleyreisz.demo.bookstore.book.model.Author;
import com.wesleyreisz.demo.bookstore.book.model.Book;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wesleyreisz on 12/28/16.
 */
public class BookService {
    List<Book> bookList = new ArrayList<>();
    {
        bookList.add(new Book("A123","War and Peace", new Author(1,"Leonardo","Tolstoy","wes@wesleyreisz.com"),new Date()));
        bookList.add(new Book("A124","Card Chronicles", new Author(2,"Matt","Mathews","wes@wesleyreisz.com"),new Date()));
        bookList.add(new Book("A125","Shogun", new Author(3,"James","Clavel","wes@wesleyreisz.com"),new Date()));
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
    public void addBook(Book book){
        if (StringUtils.isEmpty(book)){
            return;
        }

        bookList.add(book);
    }
    public void removeBook(Book book2remove){
        if (StringUtils.isEmpty(book2remove)){
            return;
        }
        for(int i = 0; i <bookList.size();i++){
            if (bookList.get(i).getIsbn().equalsIgnoreCase(book2remove.getIsbn())){
                bookList.remove(i);
            }
        }
    }
}