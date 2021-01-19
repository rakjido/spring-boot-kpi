package io.rooftop.kpi.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    private MockMvc mockMvc;

    @Test
    public void HelloWorld() throws Exception {
        // Given

        // When

        // Then
        assertThat(helloController.helloworld()).isEqualTo("HelloWorld");
    }

    @Test
    public void mockMvcTest() throws Exception {
        // Given
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
        // When
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloworld")
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));

        // Then
    }

}