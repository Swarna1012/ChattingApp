package com.example.chatting.service;

import com.example.chatting.dto.ResponseDto;
import com.example.chatting.dto.StatusDto;
import org.springframework.http.ResponseEntity;

public interface StatusService {
    ResponseEntity<ResponseDto> newStatus(StatusDto statusDto, Long userId);

    ResponseEntity<ResponseDto> getStatus(Long statusId);

    ResponseEntity<ResponseDto> deleteStatus(Long statusId);
}
