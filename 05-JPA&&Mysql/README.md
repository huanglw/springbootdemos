# 添加Jpa和Mysql-connector依赖

```
<!--mysql-connector-->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.21</version>
		</dependency>

		<!--Jpa-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
```

# 创建数据库并且配置

创建数据库springdemo

application.properties数据库配置如下：

```
#database config start
spring.datasource.url=jdbc:mysql://localhost:3306/springdemo
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
# value: create-drop create update validate
spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop
#database config ending

```

数据库插入一条name为lewin的数据，供后面接口测试用。

## 创建UserController

```
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/findByName")
    @ResponseBody
    public String findByName(){
        String queryName = "lewin";
        return userRepository.findByName(queryName).toString();
    }
}
```

请求接口：localhost:8080/user/findByName得到返回字符串为`User{id=2342353345, name='lewin', age=22}`，这个正是数据库插入的数据。

这里注意@RestController和@Controller注解的区别，这里需要用前一个。



## 涉及文件

- pom.xml添加数据库和Jpa的依赖
- User.java模型对象
- UserRepository.java数据库操作
- UserController.java控制层
- application.properties数据配置参数