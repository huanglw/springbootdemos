# 设置全局的异常处理

修改文件：

- ExceptionController.java
- GlobalExceptionHandler.java
- MyException.java
- error.html

异常处理的策略是跳转到error.html，显示异常原因和url

localhost:8080/exception/test

localhost:8080/exception/test2

上面两个连接验证异常处理