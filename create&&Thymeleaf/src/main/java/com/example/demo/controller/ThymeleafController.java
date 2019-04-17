package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/a")
    public String page(Model model){
        Person single = new Person("Lewin Huang", 18);

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        //界面用于判断是否为空的变量
        List<Person> aList = new ArrayList<Person>();
        aList.add(p1);

        //界面用于判断是否为空的变量，为空
        List<Person> aList1 = new ArrayList<Person>();

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        model.addAttribute("aList", aList);
        model.addAttribute("aList1", aList1);

        return "thymeleaf";
    }
}
