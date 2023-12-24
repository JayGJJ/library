package com.example.service;

import com.example.domain.Book;
import com.example.vo.ResponseResult;

import java.util.List;

public interface BookService {
    List<Book> findAll(String name, String author, String press);

    List<Book> findNewBooks();

    ResponseResult findById(Integer id);

    void updateBook(Book book);
}
