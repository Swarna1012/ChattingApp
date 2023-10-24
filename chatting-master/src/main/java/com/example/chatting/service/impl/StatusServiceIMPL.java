package com.example.chatting.service.impl;

import com.example.chatting.dto.ResponseDto;
import com.example.chatting.dto.StatusDto;
import com.example.chatting.entity.Status;
import com.example.chatting.entity.UserInfo;
import com.example.chatting.repository.StatusRepository;
import com.example.chatting.repository.UserInfoRepository;
import com.example.chatting.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class StatusServiceIMPL implements StatusService {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public ResponseEntity<ResponseDto> newStatus(StatusDto statusDto, Long userId) {
        Status status = new Status();
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(statusDto.getUserId());
//        status.setUserId(userInfo);
        UserInfo userInfo = userInfoRepository.findById(userId).get();
        UserInfo userInfo1=new UserInfo();
        userInfo1.setUserId(userId);
        status.setUserId(userInfo1);
        status.setUsername(userInfo.getUsername());
        status.setPath(statusDto.getPath());
        status.setMedia(statusDto.getMedia());
        status.setStatusTime(new Timestamp(System.currentTimeMillis()));
        statusRepository.save(status);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"status uploaded successfully",status));
    }

    @Override
    public ResponseEntity<ResponseDto> getStatus(Long statusId) {
        Status status = statusRepository.findById(statusId).get();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"fetched status",status));
    }

    @Override
    public ResponseEntity<ResponseDto> deleteStatus(Long statusId) {
        statusRepository.deleteById(statusId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"status deleted successfully",""));
    }


}
