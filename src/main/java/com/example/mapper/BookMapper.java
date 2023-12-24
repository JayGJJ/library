package com.example.mapper;

import com.example.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
//    多个参数要给上别名
    List<Book> list(@Param("name") String name,
                    @Param("author") String author,
                    @Param("press") String press);

    //按照时间降序，查询5本新书
    List<Book> findNewBook();

    Book findById(@Param("id") Integer id);

    void update(@Param("book") Book book);
}
