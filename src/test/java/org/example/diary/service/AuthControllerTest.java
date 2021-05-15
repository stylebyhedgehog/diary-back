package org.example.diary.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.diary.controller.TodoController;
import org.example.diary.entity.Entry;
import org.example.diary.security.jwt.JwtUtils;
import org.example.diary.service.EntryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthControllerTest {
    @Autowired
    private EntryService entryService;

    @Test
    public void contextLoads(){

        Assert.assertEquals( Entry.class,entryService.addEntry((long) 1,new Entry()).getClass());
    }
}
