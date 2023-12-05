package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController annotation is used to create Restful web services.
 * It combines @Controller and @ResponseBody and eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation
 */
@RestController
/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping(value = "/api/v1")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     *
     * Exception handling
     */

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<String> handleBlogNotFoundException(BlogNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<String> handleBlogAlreadyExistsException(BlogAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * save a new blog
     */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        Blog savedBlog;
        try {
            savedBlog = blogService.saveBlog(blog);
            return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
        } catch (BlogAlreadyExistsException ex) {
            throw ex; // Let the global exception handler handle it
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred: " + ex.getMessage(), ex);
        }
    }

    /**
     * retrieve all blogs
     */
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        return new ResponseEntity<List<Blog>>((List<Blog>) blogService.getAllBlogs(), HttpStatus.OK);
    }

    /**
     * retrieve blog by id
     */
    @GetMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId) {
        Blog blog = blogService.getBlogById(blogId);
        if (blog == null) {
            throw new BlogNotFoundException("Blog not found with id: " + blogId);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    /**
     * delete blog by id
     */
    @DeleteMapping("blog/{blogId}")
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable("blogId") int blogId) {
        return new ResponseEntity<>(blogService.deleteBlog(blogId), HttpStatus.OK);
    }


    /**
     * update blog
     */
    @PutMapping("blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        Blog updatedBlog = blogService.updateBlog(blog);
        return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
    }
}