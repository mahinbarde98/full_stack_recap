## Problem Statement: Building Spring Boot Application with Spring Profile

* This is a simple spring boot application where message is displayed based on the profile selected.

To do the exercise, complete the following steps:

**Note**: Classes provided in this exercise will show compilation errors when the exercise is cloned locally. 
You need to go through the comments thoroughly and complete the application.

    1. Manage Dependencies in pom.xml.
    2. Complete the classes and methods by analyzing the test code, so that there are no compilation errors.
    3. Implement Spring profile functionality in the application, such that
            - When the profile is set to `deployment`, the message to be returned from controller should be `This is deployment blog`
            - When the profile is set to `development`, the message to be returned from controller should be `This is development blog`
            - When the profile is set to `test`, the message to be returned from controller should be `This is test blog`
            - When no profile is set i.e; default profile, the message to be returned from controller should be `This is default blog`

    4. Run the application and test the functionality.
    5. Run all test cases and ensure that all are passed.
### Instructions
    - Take care of whitespace/trailing whitespace
    - Do not change the provided class/method names unless instructed
    - Ensure your code compiles without any errors/warning/deprecations
    - Follow best practices while coding
