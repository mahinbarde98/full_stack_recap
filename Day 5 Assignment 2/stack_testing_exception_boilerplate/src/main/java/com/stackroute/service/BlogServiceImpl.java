package com.stackroute.service;

import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import com.stackroute.domain.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    /**
     * Constructor based Dependency injection to inject BlogRepository here
     */
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * save a new blog
     */
    @Override
    public Blog saveBlog(Blog blog) {
        // Check if a blog with the same ID already exists
        if (blogRepository.existsById(blog.getBlogId())) {
            throw new BlogAlreadyExistsException("Blog with ID " + blog.getBlogId() + " already exists.");
        }
        return blogRepository.save(blog);
    }

    /**
     * retrieve all blogs
     */
    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }


    /**
     * retrieve blog by id
     */
    @Override
    public Blog getBlogById(int id) {
        Optional<Blog> optional = blogRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new BlogNotFoundException("Blog not found with ID " + id);
        }
    }

    /**
     * delete blog by id
     */
    @Override
    public Blog deleteBlog(int id) {
        Optional<Blog> optional = blogRepository.findById(id);
        if (optional.isPresent()) {
            Blog blog = optional.get();
            blogRepository.deleteById(id);
            return blog;
        } else {
            throw new BlogNotFoundException("Blog not found with ID " + id);
        }
    }

    /**
     * update blog
     */
    @Override
    public Blog updateBlog(Blog blog) {
        Optional<Blog> optional = blogRepository.findById(blog.getBlogId());
        if (optional.isPresent()) {
            Blog existingBlog = optional.get();
            existingBlog.setBlogContent(blog.getBlogContent());
            return saveBlog(existingBlog);
        } else {
            throw new BlogNotFoundException("Blog not found with ID " + blog.getBlogId());
        }
    }
}

