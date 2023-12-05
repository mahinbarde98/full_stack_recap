package com.stackroute.test.service;

import com.stackroute.domain.Blog;

import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import com.stackroute.service.BlogServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {
    // Mock BlogRepository
    @Mock
    BlogRepository blogRepository;

    // Inject Mocks to BlogServiceImpl
    @InjectMocks
    BlogServiceImpl blogService;

    private Blog blog, blog1;
    private List<Blog> blogList;
    private Optional optional;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        blog = new Blog(1, "SampleBlog", "Imneet", "SampleBlogforTesting");
        blog1 = new Blog(2, "Blog 1", "John", "Sample Blog 1 for Testing");
        optional = Optional.of(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    /*
    * write test case for saveBlog() method, by mocking the repository
    * */
    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() {
        when(blogRepository.save(blog)).thenReturn(blog);
        assertThat(blogService.saveBlog(blog)).isNotNull();
        Blog result = blogService.saveBlog(blog);
       // assertEquals(1,result.getBlogId());

    }

    /*
    * write test case for asserting RuntimeException when saveBlog() method is called, by mocking the repository
     */
    @Test
    public void givenBlogToSaveThenShouldNotReturnSavedBlog() {
        when(blogRepository.existsById(blog.getBlogId())).thenReturn(true);
        assertThrows(BlogAlreadyExistsException.class,()-> blogService.saveBlog(blog));
    }

    /*
    * write test case for getAllBlogs() method, by mocking the repository
     */
    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() {
        List<Blog> mockblogList = Arrays.asList(blog,blog1);
        when(blogRepository.findAll()).thenReturn(mockblogList);
        List<Blog> result = blogService.getAllBlogs();
        assertNotNull(result);
        assertEquals(2,result.size());
    }

    /*
    * write test case for getBlogById() method, by mocking the repository
     */
    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() {
      when(blogRepository.findById(1)).thenReturn(optional);
      Blog result = blogService.getBlogById(1);
      assertNotNull(result);
      assertEquals(blog,result);

    }

    /*
    * write test case for deleteBlog() method, by mocking the repository
     */
    @Test
    void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {

        when(blogRepository.findById(1)).thenReturn(optional);
        Blog deletedBlog = blogService.deleteBlog(1);
        assertNotNull(deletedBlog);
        assertEquals(blog,deletedBlog);
    }

    /*
    * write test case for asserting BlogNotFoundException when deleteBlog() method is called, by mocking the repository
     */
    @Test
    void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() {
      //  when(blogRepository.existsById(3)).thenReturn(Optional.empty());
        assertThrows(BlogNotFoundException.class,()->blogService.deleteBlog(3));
    }

    /*
    * write test case for updateBlog() method, by mocking the repository
     */
    @Test
    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() {

        when(blogRepository.findById(1)).thenReturn(Optional.of(blog));
        Blog existingBlog = blog;
        existingBlog.setBlogContent("Updated content");
        when(blogService.saveBlog(existingBlog)).thenReturn(existingBlog);
        Blog updatedBlog = blogService.updateBlog(blog);
        assertEquals("Updated content",updatedBlog.getBlogContent());
    }

    /*
    * write test case for asserting BlogNotFoundException when updateBlog() method is called, by mocking the repository
     */
    @Test
    public void givenBlogToUpdateThenShouldNotReturnUpdatedBlog() {
        int notExistingBlogId = 3;
        Blog notExistingBlog = new Blog(notExistingBlogId,"Not Existed","Testing","New Content");
        when(blogRepository.findById(3)).thenReturn(Optional.empty());
        assertThrows(BlogNotFoundException.class,()->blogService.updateBlog(notExistingBlog));
    }


    /*
    * write test case for asserting BlogNotFoundException when getBlogById() method is called, by mocking the repository
     */
    @Test
    public void givenNonExistentBlogIdThenShouldThrowBlogNotFoundException() {
        when(blogRepository.findById(3)).thenReturn(Optional.empty());
        assertThrows(BlogNotFoundException.class,()->blogService.getBlogById(3));
    }

    /*
    * write test case for asserting BlogNotFoundException when updateBlog() method is called, by mocking the repository
     */
    @Test
    public void givenUpdateNonExistentBlogThenShouldThrowBlogNotFoundException() {
        int notExistingBlogId = 3;
        Blog notExistingBlog = new Blog(notExistingBlogId,"Not Existed","Testing","New Content");
        when(blogRepository.findById(3)).thenReturn(Optional.empty());
        assertThrows(BlogNotFoundException.class,()->blogService.updateBlog(notExistingBlog));
    }
}