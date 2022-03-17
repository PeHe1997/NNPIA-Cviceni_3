package com.example.bookapplication;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private static Map<String, Book> bookRepo = new HashMap<>();
    static {
        Book maj = new Book();
        maj.setId("1");
        maj.setName("Maj");
        bookRepo.put(maj.getId(), maj);

        Book kytice = new Book();
        kytice.setId("2");
        kytice.setName("Kytice");
        bookRepo.put(kytice.getId(), kytice);
    }

    @Override
    public void addBook(Book book) {

        bookRepo.put(book.getId(), book);
    }

    @Override
    public void deleteBook(String id) {

        bookRepo.remove(id);
    }

    @Override
    public Collection<Book> getBooks() {

        return bookRepo.values();
    }
}
