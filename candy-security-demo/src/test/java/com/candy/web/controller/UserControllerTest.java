package com.candy.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/27 11:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void SetUP() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {

        String restult = mockMvc.perform(get("/user")
//                .param("username", "lqqb")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(restult);

    }

    @Test
    public void whenUserInfo() throws Exception {

        String result = mockMvc.perform(get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenUserInfoFail() throws Exception {

        String result = mockMvc.perform(get("/user/1111")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        String content = "{\"id\":1,\"username\":\"tom\",\"password\":null,\"birthday\":  " +date.getTime()+" }";
        String result = mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenUpdateSuccess() throws Exception {
        Date date = new Date();
        String content = "{\"id\":1,\"username\":null,\"password\":null,\"birthday\":  " +(date.getTime()+1000)+" }";
        String result = mockMvc.perform(put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform( delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()) ;
    }


}
