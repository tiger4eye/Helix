package com.titans.helix.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RemoteStatusController.class)
public class RemoteStatusControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RemoteStatusController remoteStatusController;

    @Test
    public void testA_defaultEmpty() throws Exception {
        mvc.perform(get("/helixrequest/all").contentType(APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("[]"));
    }

    @Test
    public void testA_AddEntry() {
        // mvc.perform(get("/helixrequest/add/karl/jenkins").contentType(APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("[]"));
    }
}
