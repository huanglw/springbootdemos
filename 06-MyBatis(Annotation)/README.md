> **MyBatis** is a SQL Mapping framework with support for custom SQL, stored procedures and advanced mappings.
>
> MyBatis是一个SQL映射框架支持自定义SQL，存储过程和高级映射。

# 探索过程

springboot没有提供官方的集成工具，但是可以通过添加下面依赖，来使用MyBatis

```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```



@Mapper映射类和SQL的映射可以直接再方法上加注解像下面这样

```
    //根据name查询person
    @Select("SELECT * FROM person WHERE name = #{name}")
    Person findByName(@Param("name") String name);
```

也可以通过mybatis.mapper.locations=location指定映射文件，写成下面这种形式

```
Person findByName(@Param("name") String name);
```

对应映射文件

```
<mapper namespace="com.example.demo.dao.HappinessDao">
    <select id="findByName" parameterType="String" resultType="com.example.demo.myBatis.PersonMapper">
        SELECT * FROM happiness WHERE name = #{name}
    </select>
</mapper>
```

<https://github.com/mybatis/spring-boot-starter>这里用两种方法的实现

### 创建Person.java和PersonMapper.java之后重启项目并没有建表

所以思考，MyBatis是否只管数据库操作，对于制动建表这个活依然使用@Entity来完成。

# 结论

实现了mybatis的查询功能通过注解（还有一种通过mapper配置文件的方式），同一个项目JPA和mybatis结合使用，既可以用jpa操作数据库，也可以用mybatis实现。数据库表还是通过@Entity注解自动建表。

## 修改文件

- 新建mybatis包，和下面的Person, PersonMapper, PersonController
- PersonService和PersonServiceImpl
- resources下面新建mybatis文件夹，并且新建mybatis-config.xml文件
- 修改application.properties中mybatis的相关配置（这里因为是注解方式实现的，所以不用配置mapper.xml配置文件的路径，resources/mybatis/mapper/*.xml也没有对应的配置文件）

## 注意

注意@Transactional注解的用法，这里在实现maybatis操作数据库的时候起到很重要的作用。