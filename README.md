# SpringBoot集成SpringSecurity(Bcrypt) Mybatis简单例子

这个例子包含两个用户(admin和userAdd), 你可以在BcryptExampleSQL/BcryptExampleSQL.sql文件中找到对应的语句, 默认密码为'123'. 

## 如何运行:
- 克隆这个仓库到本地
- 确保JDK版本为1.8+, Maven版本为3.x+
- 你可以通过mvn clean package命令来构建该项目
- 你可以通过以下命令运行这个服务:
~~~
mvn spring-boot:run
~~~
- 然后访问 http://localhost:8080/ , 使用用户名和密码进行登录. 
- 最后, 使用不同的用户访问下面的链接: 
  - http://localhost:8080/addOrder 
  - http://localhost:8080/showOrder 
  - http://localhost:8080/updateOrder 
  - http://localhost:8080/deleteOrder 

# Spring Boot And Spring Security (Bcrypt) And Mybatis Integration Basic Example Project

This example contains two Users(admin and userAdd), you could find it in src/main/resources/BcryptExampleSQL/BcryptExampleSQL.sql, default password is '123'. 

## How to Run:
- Clone this repository
- Make sure you are using JDK 1.8+ and Maven 3.x+
- You can build the project and run the tests by running mvn clean package
- Once successfully built, you can run the service by this method:
~~~
mvn spring-boot:run
~~~
- Then click http://localhost:8080/ , use User name and password login. 
- Finally, try access: 
  - http://localhost:8080/addOrder 
  - http://localhost:8080/showOrder 
  - http://localhost:8080/updateOrder 
  - http://localhost:8080/deleteOrder 
 with different user(admin and userAdd). 

