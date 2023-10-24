package com.example.chatting.service.impl;

import com.example.chatting.dto.ResponseDto;
import com.example.chatting.dto.UserInfoDto;
import com.example.chatting.entity.UserInfo;
import com.example.chatting.repository.UserInfoRepository;
import com.example.chatting.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceIMPL implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public ResponseEntity<ResponseDto> newUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userInfoDto.getUsername());
        userInfo.setName(userInfoDto.getName());
        userInfo.setProfileImage(userInfoDto.getProfileImage());
        userInfo.setEmail(userInfoDto.getEmail());
        userInfo.setPassword(userInfoDto.getPassword());
        userInfo.setPhNo(userInfoDto.getPhNo());
        userInfoRepository.save(userInfo);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"user information",userInfo));
    }

    @Override
    public ResponseEntity<ResponseDto> getUser(Long userId) {
        UserInfo userInfo=userInfoRepository.findById(userId).get();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"user information",userInfo));
    }
}
