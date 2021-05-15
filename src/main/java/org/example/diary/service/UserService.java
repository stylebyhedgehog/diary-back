package org.example.diary.service;

import org.example.diary.entity.Entry;
import org.example.diary.entity.Todo;
import org.example.diary.entity.User;
import org.example.diary.payload.response.ActivityResponse;
import org.example.diary.repository.UserRepository;
import org.example.diary.security.services.AccessService;
import org.example.diary.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  AccessService accessService;
    @Autowired
    private  ActivityService activityService;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Пользователь не найден"));
    }
    public ActivityResponse getUserActivity(Long id){
        User user= getUserById(id);
        accessService.checkPermissionsForPage(id);
        return new ActivityResponse(
                activityService.getEntriesCount(user),
                activityService.getCompletedTodosCount(user)
        );
    }


}
