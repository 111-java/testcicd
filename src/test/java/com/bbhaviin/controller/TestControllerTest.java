package com.bbhaviin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testEndPoint() throws Exception{

        String name = "mumbai";

        mockMvc.perform(MockMvcRequestBuilders.get("/greetings/{name}", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello " + name + " Congrats successfully completed Jenkins Demo..."));

    }


}
