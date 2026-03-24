package com.jagan.crudApp.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.jagan.crudApp.entity.Book;
import com.jagan.crudApp.repository.Repo;
import com.jagan.crudApp.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Map;


@RestController
public class BookController {

    @Autowired
    private Service service;

    @Autowired
    private Repo repo;

    @GetMapping("/")
    public String greet(){
        return "Welcome to book factory  Suiiiii  !!!!";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @Autowired
    private Cloudinary cloudinary;

    @PostMapping("/addbook")
    public Book addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam MultipartFile file) {

        try {
            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );

            String imageUrl = uploadResult.get("url").toString();

            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setImagePath(imageUrl);

            return repo.save(book);

        } catch (Exception e) {
            throw new RuntimeException("Upload failed");
        }
    }

    @GetMapping("/getbook/{id}")
    public Book getBook(@PathVariable int id) {
        return repo.findById(id).orElseThrow();
    }


    @GetMapping("/getbook/title/{title}")
    public ResponseEntity<Book> getBookByName(@PathVariable String title){
        return new ResponseEntity<>(service.getBookByTitle(title), HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(
            @PathVariable int id,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam(required = false) MultipartFile file) {

        Book book = repo.findById(id).orElseThrow();

        book.setTitle(title);
        book.setAuthor(author);

        try {

            if (file != null && !file.isEmpty()) {

                Map uploadResult = cloudinary.uploader().upload(
                        file.getBytes(),
                        ObjectUtils.emptyMap()
                );

                String imageUrl = uploadResult.get("url").toString();
                book.setImagePath(imageUrl);
            }

        } catch (Exception e) {
            throw new RuntimeException("Update failed");
        }

        return repo.save(book);
    }

    @DeleteMapping("/deletebook/{id}")
    public void deleteBookById(@PathVariable int id){
        service.deleteById(id);

    }

}
