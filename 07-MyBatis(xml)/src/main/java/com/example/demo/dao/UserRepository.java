package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    //按姓名查找
    User findByName(String name);

    //按姓名和年龄查找
    User findByNameAndAge(String name, Integer age);

    //自定义查询
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
