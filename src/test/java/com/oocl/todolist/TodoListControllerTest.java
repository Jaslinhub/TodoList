package com.oocl.todolist;

import com.oocl.todolist.Controller.TodoListController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoListController todoListController;
    @Test
    void should_return_todo_when_post_given_a_valid_todo() throws Exception {
        String requestBody = """
                {
                    "text": "Test Todo"
                }
                """;
        var result = mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("Test Todo"))
                .andExpect(jsonPath("$.done").value(false))
                .andReturn();
        /*int id = new com.fasterxml.jackson.databind.ObjectMapper().readTree(result.getResponse().getContentAsString()).get("id").asInt();
        mockMvc.perform(get("/todos/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("Test Todo"))
                .andExpect(jsonPath("$.done").value(false));*/
    }
@Test
    void should_return_all_todos_when_none_exist() throws Exception {
       mockMvc.perform(get("/todos")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json("[]"));
        assertEquals(0, todoListController.getAlltodos().size());
    }
}
