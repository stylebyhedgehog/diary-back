package org.example.diary.controller;

import org.example.diary.payload.response.ActivityResponse;
import org.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/{idUser}/activity")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ActivityResponse getUserActivity(@PathVariable Long idUser) {
        return userService.getUserActivity(idUser);
    }

}
