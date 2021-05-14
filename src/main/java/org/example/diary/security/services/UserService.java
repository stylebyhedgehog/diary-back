package org.example.diary.security.services;

import org.example.diary.entity.User;
import org.example.diary.repository.UserRepository;
import org.example.diary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Пользователь не найден"));
    }
}
