package com.Sucat.domain.chatroom.model;

import com.Sucat.domain.user.model.User;
import com.Sucat.global.common.dao.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reveiver_id")
    private User receiver;

    private String roomId; // 각 채팅방을 식별하기 위한 식별자 추가

    @Builder
    public ChatRoom(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /* Using Method */

    /* 연관관계 메서드 */
    public void setSender(User user) {
        this.sender = user;
    }

    public void setReceiver(User user) {
        this.receiver = user;
    }
}
