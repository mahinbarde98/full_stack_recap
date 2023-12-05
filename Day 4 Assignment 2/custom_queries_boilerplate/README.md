### PROBLEM STATEMENT

Create a Spring Boot application that interacts with a database using custom queries.

Steps

1. Create a new Spring Boot project using Spring Initializr.
2. Set up the necessary dependencies for Spring Data JPA and H2 database.
3. Define an entity class Book, with attributes such as id, title, author, and publishedYear.
4. Create a repository interface BookRepository, and define a custom query method that searches for books published after a certain year.
5. Implement a service class BookService, that utilizes the custom query method from the repository.
6. Create a controller BookController, with appropriate REST endpoints to interact with the BookService.

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
