package com.example.bookapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("user")
public class BookAppController {
        @Autowired
        private BookService bookService;

        @RequestMapping(value="/books")
        public ResponseEntity<Object> getBook(){
            return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
        }

        @RequestMapping(value= "/books/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> delete(@PathVariable("id") String id) {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book was deleted", HttpStatus.OK);
        }

        @RequestMapping(value = "/books", method = RequestMethod.POST)
        public ResponseEntity<Object> createBook(@RequestBody Book book) {
            bookService.addBook(book);
            return new ResponseEntity<>("Book added", HttpStatus.OK);
        }
}
