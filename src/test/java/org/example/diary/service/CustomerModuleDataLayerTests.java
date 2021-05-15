package org.example.diary.service;

import org.example.diary.security.jwt.JwtUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerModuleDataLayerTests {
    @Autowired
    private TodoService todoService;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void contextLoads() throws Exception {
//        this.mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello, guest")))
//                .andExpect(content().string(containsString("Please, login")));
//    }
@Test
    public void tan(){
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken("asd", "asd"));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    Assert.assertTrue(jwt.length()>10);
}

}
