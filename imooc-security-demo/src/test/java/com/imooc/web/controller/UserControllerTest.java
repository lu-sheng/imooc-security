package com.imooc.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringRunner.class) //如何来运行这个测试用例
@SpringBootTest  //整个类是一个测试用例的类
public class UserControllerTest {
    //    伪造的MVC的环境
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void testQueryByUsername() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "张三")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void testQueryByObj() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "张三")
                .param("age", "18")
                .param("ageTo", "60")
                .param("xxx", "tom")
                .param("size", "15")
                .param("page", "3")
                .param("sort", "age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void testGetInfo() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
        System.out.println(contentAsString);
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void testCreateSuccess() throws Exception {
        Date date = new Date();
        System.out.println(date.getTime());

        String content = "{\"username\":\"1\",\"password\":\"\",\"birthday\":\"" + date.getTime() + "\"}";
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
        System.out.println(contentAsString);
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void testUpdateSuccess() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1)
                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(date.getTime());

        String content = "{\"username\":\"1\",\"password\":\"\",\"birthday\":\"" + date.getTime() + "\"}";
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
        System.out.println(contentAsString);
    }

    /**
     * 模拟查询成功的测试用例
     */
    @Test
    public void testDeleteSuccess() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
        System.out.println(contentAsString);
    }

    /**
     * 模拟文件上传的请求
     */
    @Test
    public void whenUploadSuccess() throws Exception {
        String file = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt",
                        "multipart/form-data", "hello upload".getBytes(StandardCharsets.UTF_8))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(file);

    }


}
