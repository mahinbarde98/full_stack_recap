## Problem Statement: Use service registry for service discovery

* In this Exercise, you will concentrate on Service Discovery and its usage. It contains two Spring boot applications:
  - blog-service – A Spring Boot based microservice which exposes REST endpoint. This is a client-service application which registers itself at the registry.
  - service-registry – A Spring Boot based, which holds the information about all client-service applications. This service uses Eureka Server as Service Registry.


To solve the problem, you need to complete the following steps:

**Note**: Classes provided in this exercise will show compilation errors when the exercise is cloned locally.
You need to go through the comments thoroughly and complete the application.
  
    1. Add the required dependency to enable Eureka Server in pom.xml.
    2. Add annotation in Service Discovery service to enable the Eureka Server.
    3. Add annotation in Blog service to enable the Eureka Client.
    4. Configure properties in both Service Discovery Service and App service.
    5. Go to the browser to open Eureka dashboard and check whether the App service instance is getting registered with Eureka Server.

            
### Instructions
 - Take care of whitespace/trailing whitespace
 - Do not change the provided class/method names unless instructed
 - Ensure your code compiles without any errors/warning/deprecations 
 - Follow best practices while coding