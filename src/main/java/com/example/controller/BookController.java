package com.example.controller;

import com.example.domain.Book;
import com.example.service.BookService;
import com.example.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("book/search")
    public String select(Model model,String name,String author,String press){

        //调用Service查询图书信息
        List<Book> list = bookService.findAll(name,author,press);

        model.addAttribute("books",list);

        //返回页面 ../表示返回上一级目录
//        此处采用的是相对路径
        return "forward:../admin/books.jsp";//转发数据用forward，重定向不携带数据
    }

    @RequestMapping("book/selectNewbooks")
    public String findNewBooks(Model model){

        //调用Service查询5本新书
        List<Book> list = bookService.findNewBooks();

        //2.转发到books_new.jsp展示5本新书
        model.addAttribute("list",list);
        //绝对路径 是以/开始，此处的/其实代表的是http://ip:port/
        return "forward:/admin/books_new.jsp";
    }

    @RequestMapping("book/book/findById")
    @ResponseBody //springMVC的知识：将响应的java对象转换成json格式返回
    public ResponseResult findBookById(Integer id){

        ResponseResult result = bookService.findById(id);


        return result;
    }

    @RequestMapping("book/book/editBook")
    //springMVC的知识：book对象的属性名和前端提交参数的key一致，即可直接接受表单数据，封装到java实体对象
    public ResponseResult update(Book book){
        bookService.updateBook(book);
        return ResponseResult.okResult("修改操作成功");
    }
}
