package com.example.bookapplication;

import java.util.Collection;

public interface BookService {
    void addBook(Book book);
    void deleteBook(String id);
    Collection<Book> getBooks();
}
