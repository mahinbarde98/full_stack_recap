# Assignment: Implementing Rest Template and making 3rd party API call

## Assignment Task:
You are tasked with creating a Spring Boot application that involves:
#### 1. Implement Rest Template in your application 
#### 2. Make a 3rd party api call to WeatherAPI to get weather information of a city 
Follow these steps to complete the assignment:

### Setup:
- Create a new Spring Boot project or an existing one using the latest version of Spring Boot. This is the boilerplate with an existing project.
- Add the necessary dependencies.
- Sign up for free Weather API service (https://www.weatherapi.com/). Use this API key in your project
- Use API explorer to get the API url format (https://www.weatherapi.com/api-explorer.aspx)

### Custom Service:
- Add your API key here.
- Add the Base Url
- Implement a method which takes city as a input and returns weather information as output. Use Rest Template to make the 3rd party API call.

### Controller:
- Create a RESTful controller with at least one endpoint.
- In the controller, use the custom service to demonstrate the custom business logic in response to an HTTP request.