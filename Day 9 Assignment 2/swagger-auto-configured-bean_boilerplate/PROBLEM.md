# Assignment: Implementing Swagger and Overriding auto-configured beans 

## Background:
In a Spring Boot application, auto-configured beans provided by Spring Boot are convenient and help streamline development. However, there may be situations where you need to customize or override these beans to fit the specific requirements of your project. This assignment aims to assess your understanding of customizing auto-configured beans in a Spring Boot application.

## Assignment Task:
You are tasked with creating a Spring Boot application that involves:
#### 1.  Implement Swagger openapi in you application
#### 2. Customizing auto-configured beans. 
Follow these steps to complete the assignment:

### Setup:
- Create a new Spring Boot project or an existing one using the latest version of Spring Boot. This is the boilerplate with an existing project.
- Add the necessary dependencies along with OpenApi(swagger) dependency.

### Custom Data Source:
- Override the auto-configured DataSource bean with a custom DataSource implementation.
- You can create a simple custom DataSource class with a unique name.

### Custom Service:
- Create a custom service class with a method that performs some logic (e.g. Just return any String value or some unique business logic).
- Inject this custom service into a controller or a service class within your application.

### Controller:
- Create a RESTful controller with at least one endpoint.
- In the controller, use the custom service to demonstrate the custom business logic in response to an HTTP request.