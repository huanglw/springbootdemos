package com.example.demo.service.impl;

import com.example.demo.myBatis.Person;
import com.example.demo.myBatis.PersonMapper;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;


    @Override
    public Person findPersonById(Long id) {
        //Map<String, Object> attributes = new HashMap<>();
        Person person = this.personMapper.findById(id);
        return person;
    }
}
