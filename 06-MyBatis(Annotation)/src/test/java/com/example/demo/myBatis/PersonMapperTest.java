package com.example.demo.myBatis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PersonMapperTest {
    @Autowired
    PersonMapper personMapper;

    @Test
    public void findByName() throws Exception {

        Person pp = personMapper.findById(new Long(1));
        assertNotNull(pp);
    }

}