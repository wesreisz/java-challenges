package com.wesleyreisz.demo.bookstore.book;

import com.wesleyreisz.demo.bookstore.book.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wesleyreisz on 12/28/16.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks(){
        return new BookService().getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{isbn}")
    public Book getBook(@PathVariable String isbn){
        return new BookService().findByISBN(isbn);
    }

    /*TODO: Add the put, delete methods*/

}
