package com.example.demo.myBatis;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonMapper {

    //根据name查询person
//    @Select("select * from person where id = #{id}")
    Person findById(@Param("id") Long id);

//    @Results({
//            @Result(property = "name", column = "name"),
//            @Result(property = "age", column = "age")
//    })
//    @Select("SELECT name,age FROM person")
//    List<Person> findAll();
//
//    @Insert("INSERT INTO person(name, age) VALUES(#{name},#{age}")
//    int insert(@Param("name") String name, @Param("age") Integer age);
//
//    @Update("UPDATE person SET age=#{age} WHERE name=#{name}")
//    void update(Person person);
//
//    @Delete("DELETE FROM person WHERE id=#{id}")
//    void delete(Long id);
//
//    @Insert("INSERT INTO person(name,age) VALUES(#{name}, #{age})")
//    int insertByPerson(Person person);
//
//    @Insert("INSERT INTO person(name,age) VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
//    int insertByMap(Map<String, Object> map);
}

