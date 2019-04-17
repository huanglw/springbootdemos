# springbootdemos
springboot上手

# 第一部分创建项目+thymeleaf模板引擎支持
个人其实不推荐使用thymeleaf，原因很简单，前端开发过分依赖后端，在时下都讲前后端分离的大环境下，还使用thymeleaf确实有点走偏。
但是，凡事有利有弊，架不住某些项目需求就用到了，所以了解一下总是好的。

先将让spring boot支持thymeleaf的配置
**方法一：**
- pom.xml添加依赖
```
<!--thymeleaf  -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
```
- application.properties配置
```
#thymeleaf start
spring.thymeleaf.mode=HTML5
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.content-type=text/html
#开发时关闭缓存,不然没法看到实时页面
spring.thymeleaf.cache=false
#thymeleaf end
```
如上配置完了之后，maven reimport一下依赖。



**方法二：**
在创建spring boot项目的时候勾选thymeleaf引擎依赖。这样可以省去上面的配置，添加依赖之后使用默认配置
`org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties`这个类里面有默认的配置。
spring-boot很多配置都有默认配置：
比如默认页面映射路径为classpath:/templates/*.html
同样静态文件路径为classpath:/static/
