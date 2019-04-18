package com.example.demo.service;

import com.example.demo.myBatis.Person;

import java.util.Map;

public interface PersonService {

    Person findPersonById(Long id);
}
