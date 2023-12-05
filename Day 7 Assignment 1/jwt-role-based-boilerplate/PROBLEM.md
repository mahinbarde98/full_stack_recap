## Problem Statement: Practise securing Microservices(JWT)
        
* This is a multi-module application with two microservices:
  - jwt-service: A Spring Boot based microservice that generates a JSON Web Token(JWT) which is used to authenticate user based on Role.
  - app-service: A Spring Boot based microservice which receives a request with a JWT, and the token is validated. This request will be intercepted by the filter.


  
To solve the problem, you need to complete the following steps:

**Note**: Classes provided in this exercise will show compilation errors when the exercise is cloned locally.
You need to go through the comments thoroughly and complete the application.
  
    1. Manage dependencies in pom.xml using Maven Central.
    2. Classes and methods should be completed by analyzing the test code, so that there are no compilation errors.
    3. The functionality of methods should be completed, such that all the test cases pass.
    4. Test in Postman to see if you are able to login and the token is generated.
    5. Test in Postman to validate the token.

### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided class/method names unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding
