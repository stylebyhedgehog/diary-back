package org.example.diary.service;

import org.example.diary.repository.UserRepository;
import org.example.diary.security.services.AccessService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SecurityTestConfig.class
)
@AutoConfigureMockMvc
public class ServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    AccessService accessService;

    @Test
    @WithMockUser
    public void getUser() {
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            userService.getUserById((long) 1);
        });
        HttpStatus expectedMessage = HttpStatus.NOT_FOUND;
        HttpStatus actualMessage = exception.getStatus();
        Assert.assertSame(actualMessage, expectedMessage);
    }

}
