package com.jagan.crudApp.service;

import com.jagan.crudApp.entity.Book;
import com.jagan.crudApp.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repo repo;

    public List<Book> getAllBooks(){
    return repo.findAll();
    }

    public void addBook(Book book) {
        repo.save(book);
    }

    public Book getBookById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Book getBookByTitle(String title) {
       return repo.findByTitle(title);
    }

    public Book updateBook(Book book) {
      return repo.save(book);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
