package com.example.service.impl;

import com.example.domain.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll(String name, String author, String press) {
        return bookMapper.list(name,author,press);
    }

    @Override
    public List<Book> findNewBooks() {
        return bookMapper.findNewBook();
    }

    @Override
    public ResponseResult findById(Integer id) {

        Book book = bookMapper.findById(id);

        return ResponseResult.okResult(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.update(book);
    }
}
