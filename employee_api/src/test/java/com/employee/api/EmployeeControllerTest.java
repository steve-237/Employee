package com.employee.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.employee.api.controller.EmployeeController;
import com.employee.api.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployee() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
    }
}
