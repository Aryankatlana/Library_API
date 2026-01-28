package com.zimetrics.task.Libraryapi.repository;

import com.zimetrics.task.Libraryapi.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface bookRepository extends JpaRepository<book, UUID> {

    List<book> findByYear(int year);
}
