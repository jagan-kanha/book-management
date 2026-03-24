package com.jagan.crudApp.repository;

import com.jagan.crudApp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository <Book,Integer>{

    public Book findByTitle(String title);
}
