package com.example.demo.controller;

import com.example.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/test")
    public String test() throws Exception{
        throw new Exception("发生错误");
    }

    @RequestMapping("test2")
    public String test2() throws MyException{
        throw new MyException("发生错误2");
    }
}
