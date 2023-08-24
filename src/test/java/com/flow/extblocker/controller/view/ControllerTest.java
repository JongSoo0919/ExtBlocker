package com.flow.extblocker.controller.view;

import com.flow.extblocker.service.impl.CustomExtImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomExtImpl customExt;

    @DisplayName("index 페이지 호출")
    @Test
    public void getIndexPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andDo(MockMvcResultHandlers.print());
    }
}