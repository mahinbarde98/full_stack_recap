package com.stackroute.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.controller.BlogController;
import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class BlogControllerTest {

    private MockMvc mockMvc;

    // Mock BlogService layer
    @Mock
    BlogService blogService;

    // Inject BlogService into BlogController
//    @Autowired
//    public BlogController(BlogService blogService){this.blogService = blogService;}
//
    @InjectMocks
    BlogController blogController;
    private Blog blog;
    private List<Blog> blogList;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
        blog = new Blog();
        blog.setBlogId(1);
        blog.setBlogTitle("DemoBlog");
        blog.setAuthorName("Imneet");
        blog.setBlogContent("SampleBlogforTesting");
        blogList = new ArrayList<>();
        blogList.add(blog);
    }

    @AfterEach
    public void tearDown() {
        blog = null;
    }

    /*
     * Test - POST mapping "/api/v1/blog" to save a blog, by mocking service class
     */
    @Test
    public void givenBlogToSaveThenShouldReturnSavedBlog() throws Exception {
       // when(blogService.saveBlog(blog)).thenReturn(blog);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(blog);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj)).andExpect(status()
                .isCreated());
    }

    /*
     * Test - GET mapping "/api/v1/blogs" to get all blogs, by mocking service class
     */
    @Test
    public void givenGetAllBlogsThenShouldReturnListOfAllBlogs() throws Exception {
        when(blogService.getAllBlogs()).thenReturn(blogList);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(blogList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/blogs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj)).andExpect(status()
                .isOk());
    }

    /*
     * Test - GET mapping "/api/v1/blog/1" to get a blog by id, by mocking service class
     */
    @Test
    public void givenBlogIdThenShouldReturnRespectiveBlog() throws Exception {
        when(blogService.getBlogById(1)).thenReturn(blog);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(blog);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/blog/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj)).andExpect(status()
                .isOk());
    }

    /*
     * Test - DELETE mapping "/api/v1/blog/1" to delete a blog by id, by mocking service class
     */
    @Test
    public void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() throws Exception {
        when(blogService.deleteBlog(1)).thenReturn(blog);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(blog);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/blog/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObj)).andExpect(status()
                .isOk());

    }

    /*
     * Test - PUT mapping "/api/v1/blog" to update a blog, by mocking service class
     */
    @Test
    public void givenBlogToUpdateThenShouldReturnUpdatedBlog() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(blog);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/blog")
                .contentType(MediaType.APPLICATION_JSON).content(jsonObj)
                ).andExpect(status()
                .isOk());
    }

    /*
     * Test - GET mapping "/api/v1/blog/2" to get a blog by id, by mocking service class
     * throw BlogNotFoundException and Expect string "Blog not found with id: 2"
     */
    @Test
    public void givenBlogIdNotFoundThenShouldReturnNotFound() throws Exception {
    }

    /*
     * Test - GET mapping "/api/v1/blog/1" to get a blog by id, by mocking service class
     * throw RuntimeException and Expect string "An error occurred: Some error"
     */
    @Test
    public void givenBlogServiceThrowsExceptionThenShouldReturnInternalServerError() throws Exception {
    }

    /*
     * Test - POST mapping "/api/v1/blog" to save a blog, by mocking service class
     * throw BlogAlreadyExistsException and Expect string "Blog with ID 1 already exists"
     */
    @Test
    public void givenBlogAlreadyExistsThenShouldReturnConflict() throws Exception {
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}