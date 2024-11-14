package com.kwhackathon.broom.chatMessage.entity;

import com.kwhackathon.broom.chatRoom.entity.ChatRoomForTeam;
import com.kwhackathon.broom.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message_for_team")
@Data
public class ChatMessageForTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_message_id",unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id",nullable = false)
    private ChatRoomForTeam chatRoom;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "message", nullable = false)
    private String message;

}
