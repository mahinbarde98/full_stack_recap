### PROBLEM STATEMENT

Create a Spring Boot application that handles CRUD operations and returns a custom response in JSON format.
The response should include a custom message and HTTP status.

Custom response should include the following message-

GET - "Successfully retrieved data!"
POST - "Successfully added data!"
PUT - "Updated"
DELETE - "Deleted!"

Steps:

1. Create a new Spring Boot project using Spring Initializr.
2. Create a ResponseHandler class with a method to return custom JSON response that includes the necessary fields.
4. In the ProductController, add the custom responses for the appropriate CRUD operations
5. Run the application and test the endpoint using a web browser or API testing tool.

### INSTRUCTIONS

## Seed code - Boilerplate

### Instructions
Refer the problem.md file for problem description.

#### To use this as a boilerplate for your assignment, please follow these steps

1. **FORK** this repository in your Gitlab account

2. **CLONE** the forked repository, containing the boilerplate in your local machine

3. Complete the solution as per the instructions given in problem.md and the boilerplate code

5. Use the following command to update the index using the current content found in the working tree, to prepare the content staged for the next commit.

   `git add .`

6. Commit and Push the project to git

   `git commit -a -m "Initial commit | or place your comments according to your need"`

   `git push -u origin master`

7. Check on the git repo online, if the files have been pushed

8. Submit your solution on Hobbes

### Further Instructions on Release
- Right click on the Assignment, select Run As -> JUnit Test to run the TestCases.
