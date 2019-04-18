package com.example.demo.myBatis;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/{id}")
    public @ResponseBody String getByName(@PathVariable("id") String id){
        Long queryID = Long.valueOf(id);
        return personService.findPersonById(queryID).toString();
    }
}
