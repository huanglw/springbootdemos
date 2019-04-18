# 本章节内容

同05章节，不过mybatis不采用注解方式，改用xml配置实现。

# 修改内容

- 去掉PersonMapper上的注解
- resources/mybatis/mapper下增加PersonMapper.xml文件
- application.properties文件中增加mybatis.mapper-locations=classpath:mybatis/mapper/*.xml

