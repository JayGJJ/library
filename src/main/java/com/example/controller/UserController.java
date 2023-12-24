package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired//spring的自动装配，将@service创建的对象赋值给这个变量
    private UserService userService;

    @RequestMapping("/login")
    //参数名称必须要和前端提交的参数名一致就能接收：springMVC的知识
    public String login(String email, String password, Model model, HttpSession session){
        //调用service方法校验登录
        User user = userService.login(email,password);

        //给出响应
        if(user==null){
            //登陆失败
            model.addAttribute("msg","用户名或密码错误");
            return "forward:admin/login.jsp";
        }else {
            //登陆成功
            session.setAttribute("USER_SESSION",user);//将信息保存到session中在前端页面中展示
            return "redirect:admin/main.jsp";//springMVC的知识，表示重定向到books.jsp页面
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //销毁session以及里面的用户信息
        session.invalidate();
        return "redirect:admin/login.jsp";
    }
}
