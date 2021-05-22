package org.example.diary.controller;


import org.example.diary.entity.Entry;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/api/user/test")
    public String isUser() {
        return  "simple_user_accepted";
    }
    @GetMapping("/api/admin/test")
    public String isAdmin() {
        return  "admin_accepted";
    }
}
