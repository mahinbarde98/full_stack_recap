## Problem Statement: Enable Centralized Configuration using Configuration Server

* In this Exercise, you will externalize the  properties of a  project codebase to a centralized configuration server. The application contains two Spring Boot applications:
  - blog-service – A Spring Boot based microservice which exposes urls to enable CRUD functionality. 
  - config-service– A Spring Cloud centralized Config Server.

To solve the problem, you need to complete the following steps:

**Note**: Classes provided in this exercise will show compilation errors when the exercise is cloned locally.
You need to go through the comments thoroughly and complete the application.
  
        1. Add the required dependency to enable Config Server in pom.xml.
        2. Add annotation to make the config-server act like Spring Config Server. 
        3. Create a repository and add the properties for whatever database you are choosing with the name of Config Client such as blog-service.properties.
        4. Add properties in application.properties to fetch the properties from Git repository.
        5. Test in Postman to see if you can access the Blog service.

* Below are some of the properties of blog-service.properties in centralized configuration server
  ```
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=password
  spring.h2.console.enabled=true
  server.port = 8090
  ```

  
### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided class/method names unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding
 
 
 




  
### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided class/method names unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding
 
 
 



