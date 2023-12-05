## Problem Statement: Perform asynchronous event-driven messaging across distributed services

* In this exercise, you will be using RabbitMQ which is an AMQP(Advanced Message Queuing Protocol) broker and will perform asynchronous event-driven messaging across distributed services. This is a multi-module application with two microservices.

  - producer-service: A Spring Boot based microservice that publishes the message to the direct exchange with routing key.
  - consumer-service: A Spring Boot based microservice which consumes the message asynchronously.
  

To solve the problem, you need to complete the following steps:

**Note**: Classes provided in this exercise will show compilation errors when the exercise is cloned locally.
You need to go through the comments thoroughly and complete the application.
  
    1. Install and Manage RabbitMQ
    2. Manage Dependencies in pom.xml using Maven Central.
    3. Complete the classes and implement the methods by following the comments given.
    4. Test in the Postman to see if you are able to publish a JSON object.
    5. Run the consumer-service and check is the JSON object is consumed.

### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided class/method names unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding