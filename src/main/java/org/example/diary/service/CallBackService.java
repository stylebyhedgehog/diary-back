package org.example.diary.service;

import org.example.diary.entity.CallBack;
import org.example.diary.entity.Todo;
import org.example.diary.entity.User;
import org.example.diary.payload.response.CallBackResponse;
import org.example.diary.repository.CallBackRepository;
import org.example.diary.security.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CallBackService {
    @Autowired
    private CallBackRepository callBackRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AccessService accessService;

    public CallBackResponse addCallBack(Long idUser, CallBack callBack){
        User user = userService.getUserById(idUser);
        accessService.checkPermissionsForPage(idUser);
        callBack.setDate(new Date());
        callBack.setUser(user);
        return CallBackResponse.from(callBackRepository.save(callBack));
    }


    public List<CallBackResponse> getAllCallBacks(Long idUser){
        accessService.checkPermissionsForPage(idUser);
        List<CallBackResponse> callBackResponses= callBackRepository.findAll().stream()
                .map(CallBackResponse::from)
                .collect(Collectors.toList());

       return callBackResponses;
    }
    public List<CallBackResponse> getUserCallBacks(Long idUser){
        User user = userService.getUserById(idUser);
        accessService.checkPermissionsForPage(idUser);
        List<CallBackResponse> callBackResponses= user.getCallBacks().stream()
                .map(CallBackResponse::from)
                .collect(Collectors.toList());
        return callBackResponses;
    }
}
