package com.hhovhann.chatbackendapi.chatroom.repository;

import com.hhovhann.chatbackendapi.chatroom.document.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
