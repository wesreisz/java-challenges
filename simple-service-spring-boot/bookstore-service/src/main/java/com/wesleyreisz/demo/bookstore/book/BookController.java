package com.wesleyreisz.demo.bookstore.book;

import com.wesleyreisz.demo.bookstore.book.model.Book;
import com.wesleyreisz.demo.bookstore.book.model.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * Created by wesleyreisz on 12/28/16.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getBooks(){
        return new ResponseEntity<>(BookServiceMock.getInstance().getAll(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{isbn}")
    public ResponseEntity getBook(@PathVariable String isbn){
            Book book = BookServiceMock.getInstance().findByISBN(isbn);
            if (!StringUtils.isEmpty(book.getName())){
                return new ResponseEntity<>(book, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addBook(@RequestBody Book input) throws ParseException{
        return new ResponseEntity<>(BookServiceMock.getInstance().addUpdateBook(input), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{isbn}")
    public ResponseEntity removeBook(@PathVariable String isbn){
        if (StringUtils.isEmpty(BookServiceMock.getInstance().findByISBN(isbn).getAuthor())){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(BookServiceMock.getInstance().removeBook(new Book(isbn)), HttpStatus.OK);
    }
}
