package com.zimetrics.task.Libraryapi.service;

import com.zimetrics.task.Libraryapi.entity.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.zimetrics.task.Libraryapi.repository.bookRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class bookService {

    @Autowired
    private bookRepository bookrepo;

    public book addBook(book book){
        return bookrepo.save(book);
    }

    public book getById(UUID id){
        return bookrepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not foundwith id "+id));
    }

    public List<book> getAll(){
        return bookrepo.findAll();
    }

    public List<book> getByYear(int year){
        return bookrepo.findByYear(year);
    }

    public void delete(UUID id){
        if(!bookrepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not foundwith id "+id);
        }
        bookrepo.deleteById(id);
    }
}
