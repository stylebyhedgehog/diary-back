package org.example.diary.controller;


import org.example.diary.entity.CallBack;
import org.example.diary.entity.Todo;
import org.example.diary.payload.response.CallBackResponse;
import org.example.diary.service.CallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class CallBackController {
    @Autowired
    private CallBackService callBackService;

    @PostMapping("/api/user/{idUser}/callbacks")
    public @ResponseBody
    CallBackResponse addCallback(@PathVariable Long idUser, @Valid @RequestBody final CallBack callBack){ return callBackService.addCallBack(idUser,callBack); }

    @GetMapping("/api/user/{idUser}/callbacks")
    public  @ResponseBody
    List<CallBackResponse> getUserCallBacks(@PathVariable Long idUser){
        return callBackService.getUserCallBacks(idUser);
    }

    @GetMapping("/api/admin/{idUser}/callbacks")
    public  @ResponseBody
    List<CallBackResponse> getAllCallBacks(@PathVariable Long idUser){
        return callBackService.getAllCallBacks(idUser);
    }

}
