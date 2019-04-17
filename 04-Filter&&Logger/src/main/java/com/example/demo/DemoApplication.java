package com.example.demo;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
@ServletComponentScan("com.example.demo.filter")
public class DemoApplication {
	//从配置文件application.properties中读取配置参数值
	@Value("${website.name}")
	private String name;
	@Value("${website.createtime}")
	private String createtime;

	@RequestMapping("/")
	public String index(Model model){
//		return "Hello here is homepage. website name: "+name+", website createtime: "+ createtime;
		Person single = new Person("Lewin Huang", 18);

		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("xx", 11);
		Person p2 = new Person("yy", 22);
		Person p3 = new Person("zz", 33);
		people.add(p1);
		people.add(p2);
		people.add(p3);

		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);

		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
