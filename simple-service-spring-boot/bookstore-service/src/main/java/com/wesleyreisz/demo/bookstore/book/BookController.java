package com.wesleyreisz.demo.bookstore.book;

import com.wesleyreisz.demo.bookstore.book.model.Book;
import com.wesleyreisz.demo.bookstore.book.model.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wesleyreisz on 12/28/16.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks(){
        return BookService.getInstance().getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{isbn}")
    public Object getBook(@PathVariable String isbn){
        try{
            return BookService.getInstance().findByISBN(isbn);
        }catch (RuntimeException e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Book addBook(@RequestBody Book input){
        return BookService.getInstance().addUpdateBook(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{isbn}")
    public ServiceResponse removeBook(@PathVariable String isbn, HttpServletRequest request){
        return BookService.getInstance().removeBook(new Book(isbn));
    }
}
