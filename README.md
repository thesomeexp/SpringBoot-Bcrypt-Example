# Spring Boot And Spring Security (Bcrypt) And Mybatis Integration Basic Example Project

This example contains two Users(admin and userAdd), you could find it in src/main/resources/BcryptExampleSQL/BcryptExampleSQL.sql, default password is '123'. 

## How to Run:
- Clone this repository
- Make sure you are using JDK 1.8 and Maven 3.x
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


