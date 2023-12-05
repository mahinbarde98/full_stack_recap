
## Problem Statement:Distributed tracing in Microservices
    Given a Microservice application, trace calls using micrometer and zipkin

## Assignment Tasks:
*  Add micrometer maven dependency globally to all services
*  Add necessary properties in microservices
*  Write logic for the REST controllers mappings in following microservices:
    * portal-service (gets data from address-service and customer-service through http request)
    * address-service (gets data from H2 database)
    * customer-service (gets data from H2 database)

## Running the application locally after cloning

1. After implementing the requirements, execute the following maven command in the parent/root project
   mvn clean package
2. Start Zipkin. Instruction for installation and starting these are provided in below section
3. After completing assignment tasks start the microservices in this order:
    1. eureka
    2. gateway
    3. address-service
    4. customer-service
    5. portal-service
4. Call a GET request to URL: `http://localhost:8080/user/3` (Zipkin server should trace this request to other services also)
## Following software needs to be available/installed in the local environment
**Zipkin**
> Refer the steps provided at the below url to install and start zipkin server

         -> curl -sSL https://zipkin.io/quickstart.sh | bash -s
         -> java -jar zipkin.jar

## Instructions
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Ensure your code compiles without any errors/warning/deprecations
- Follow best practices while coding