package com.wesleyreisz.demo.bookstore.book;

import com.wesleyreisz.demo.bookstore.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * Created by wesleyreisz on 12/28/16.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookServiceMock service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getBooks(){
        return new ResponseEntity<>(new BookServiceMock().getAll(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{isbn}")
    public ResponseEntity getBook(@PathVariable String isbn){
            Book book = service.findByISBN(isbn);
            if (!StringUtils.isEmpty(book.getName())){
                return new ResponseEntity<>(book, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addBook(@RequestBody Book input) throws ParseException{
        return new ResponseEntity<>(service.addUpdateBook(input), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{isbn}")
    public ResponseEntity removeBook(@PathVariable String isbn){
        if (StringUtils.isEmpty(service.findByISBN(isbn).getAuthor())){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.removeBook(new Book(isbn)), HttpStatus.OK);
    }
}
