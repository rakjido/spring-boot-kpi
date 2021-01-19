package io.rooftop.kpi.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TaskApiControllerTest {
    @Autowired
    private TaskApiController taskApiController;

    private MockMvc mockMvc;

//    @Test
//    public void findById_테스트() throws Exception {
//        // Given
//        mockMvc = MockMvcBuilders.standaloneSetup(taskApiController).build();
//        // When
//        ResultActions resultActions = mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/tasks/1"))
//                .andDo(print());
//
//        // Then
//                resultActions.andExpect(status().isOk());
////                .andExpect(jsonPath("$.taskName").value("In-Person Demo"));
//    }

}