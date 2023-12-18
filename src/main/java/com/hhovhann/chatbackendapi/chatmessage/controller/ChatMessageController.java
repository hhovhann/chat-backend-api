package com.hhovhann.chatbackendapi.chatmessage.controller;

import com.hhovhann.chatbackendapi.chatmessage.service.ChatMessageService;
import com.hhovhann.chatbackendapi.chatmessage.model.ChatNotification;
import com.hhovhann.chatbackendapi.chatmessage.document.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessages(@Payload ChatMessage chatMessage) {
        ChatMessage savedMessage = chatMessageService.save(chatMessage);

        // john/queue/messages
        simpMessagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(),
                "queue/messages",
                ChatNotification.builder()
                        .id(savedMessage.getId())
                        .senderId(savedMessage.getSenderId())
                        .recipientId(savedMessage.getRecipientId())
                        .content(savedMessage.getContent()));
    }

    @GetMapping("/api/v1/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable("senderId") String senderId, @PathVariable("recipientId") String recipientId) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }
}
