package com.zimetrics.task.Libraryapi.controllers;

import com.zimetrics.task.Libraryapi.entity.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zimetrics.task.Libraryapi.service.bookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class bookController {

    @Autowired
    private bookService bookService;

    // Add new Book in Library
    @PostMapping
    public ResponseEntity<book> addBook(@RequestBody book newBook){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookService.addBook(newBook));
    }

    //Get book by Id
    @GetMapping("/{id}")
    public ResponseEntity<book> getBookById(@PathVariable UUID id){
        book book1 = bookService.getById(id);
        return ResponseEntity.ok(book1);
    }

    //Get All Books
    @GetMapping
    public ResponseEntity<List<book>> getAllBooks(){
        List<book> list = bookService.getAll();

        return ResponseEntity.ok(list);
    }

    //Search book by year
    @GetMapping("/search")
    public ResponseEntity<List<book>> getBooksByYear(@RequestParam int year){

        System.out.println("Year received in controller: " + year);

        return ResponseEntity.ok(bookService.getByYear(year));
    }

    //Delete book by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        bookService.delete(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
