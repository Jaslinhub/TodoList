package com.oocl.todolist;

import com.oocl.todolist.Controller.TodoListController;
import com.oocl.todolist.Repository.TodoRespository;
import org.junit.jupiter.api.BeforeEach;
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

    @Autowired
    private TodoRespository todoListRepository;

    @BeforeEach
    public void setUp(){
        todoListRepository.clear();
    }
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
    }
@Test
    void should_return_all_todos_when_none_exist() throws Exception {
       mockMvc.perform(get("/todos")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json("[]"));
        assertEquals(0, todoListController.getAlltodos().size());
    }
    @Test
    void should_return_one_to_do_when_one_exist() throws Exception {
        String requestBody = """
                {
                    "text": "Buy milk"
                }
                """;
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("Buy milk"))
                .andExpect(jsonPath("$.done").value(false))
                .andReturn();
        mockMvc.perform(get("/todos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].text").value("Buy milk"))
                .andExpect(jsonPath("$[0].done").value(false))
                .andReturn();
        assertEquals(1, todoListController.getAlltodos().size());
    }

    @Test
    void should_reject_empty_text_when_post_given_a_todo_with_empty_text() throws Exception {
        String requestBody = """
                {
                    "text": ""
                }
                """;
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void should_reject_no_text_when_post_given_a_todo_with_no_text() throws Exception {
        String requestBody = """
                {
                }
                """;
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }
}
