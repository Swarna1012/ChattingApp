package com.example.chatting.dto;

import com.example.chatting.entity.Post;
import com.example.chatting.entity.UserInfo;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentsDto {
    private Long commentId;
    private Long userId;
    private Long postId;
    private String comment;
    private Timestamp commentedAt;
}
