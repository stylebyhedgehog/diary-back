package org.example.diary.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SecurityTestConfig.class
)
@AutoConfigureMockMvc
public class SecuredActionsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("simpleUserTest")
    public void testWithGivenRoleUser() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/test")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("simple_user_accepted")));
    }

    @Test
    @WithUserDetails("adminTest")
    public void testWithGivenRoleAdmin() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/test")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("admin_accepted")));
    }

}