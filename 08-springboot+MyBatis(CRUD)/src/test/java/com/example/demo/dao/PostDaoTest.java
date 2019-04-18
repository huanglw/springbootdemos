package com.example.demo.dao;

import com.example.demo.model.Post;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class PostDaoTest {
    @Autowired
    PostDao postDao;

    @Test
    public void findAll() throws Exception {
        List<Post> ps = postDao.findAll();
    }

}