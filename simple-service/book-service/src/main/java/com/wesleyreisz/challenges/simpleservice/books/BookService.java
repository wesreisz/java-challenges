package com.wesleyreisz.challenges.simpleservice.books;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wesleyreisz on 12/12/16.
 */
public class BookService{
    private Book[] books = new Book[2];
    private Author[] authors = new Author[2];

    {
        authors[0] = new Author(1,"Dave Thomas", "dave@1rubyway.com");
        authors[1] = new Author(2,"Andy Hunt", "andy@hunt.com");
        books[0]= new Book(1,"234234sersdf","Pragmatic Programmer",authors, new Date());

        //authors = new Author[0];
        //authors[0] = new Author(3,"Kathy Sierra", "kathy@beautifulhorses.com");
        //books[0]= new Book(2,"sadjfhgasd773","Head First Design Patterns",authors, new Date());
    }

    public Book find(long id){
        for(Book book : books){
            if(id==book.getId()){
                return book;
            }
        }
        return new Book();
    }

}
