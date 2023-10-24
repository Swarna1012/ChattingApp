package com.example.chatting.controller;

import com.example.chatting.dto.ResponseDto;
import com.example.chatting.dto.UserInfoDto;
import com.example.chatting.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping()
    public ResponseEntity<ResponseDto> newUser(@RequestBody UserInfoDto userInfoDto){
        return userInfoService.newUser(userInfoDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long userId){
        return userInfoService.getUser(userId);
    }
}
