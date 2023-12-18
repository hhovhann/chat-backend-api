package com.hhovhann.chatbackendapi.chatmessage.repository;

import com.hhovhann.chatbackendapi.chatmessage.document.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
}
