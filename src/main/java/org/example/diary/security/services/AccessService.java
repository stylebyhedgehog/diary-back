package org.example.diary.security.services;

import org.example.diary.entity.Entry;
import org.example.diary.entity.Todo;
import org.example.diary.entity.User;
import org.example.diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccessService {

    @Autowired
    private UserRepository userRepository;

//    public User getCurrentUser(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userName= auth.getName();
//        return userRepository.findByUsername(userName).orElseThrow(()->
//                new ResponseStatusException(
//                        HttpStatus.NOT_FOUND, "Пользователь не найден"));
//    }

    public void checkPermissionsForPage(Long idUser){
//        User user = getCurrentUser();
//        if (!user.getId().equals(idUser)){
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Ошибка доступа");
//        }
    }

    public void checkPermissionsForObject(Object object){
//        User user = getCurrentUser();
//        if (object instanceof Entry){
//            Entry entry=(Entry)object;
//            if (!entry.getUser().getUsername().equals(user.getUsername())){
//                throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Ошибка доступа");
//            }
//        }
//        if (object instanceof Todo){
//            Todo todo=(Todo)object;
//            if (!todo.getUser().getUsername().equals(user.getUsername())){
//                throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Ошибка доступа");
//            }
//        }
    }


}
