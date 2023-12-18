package com.hhovhann.chatbackendapi.chatmessage.service;

import com.hhovhann.chatbackendapi.chatmessage.document.ChatMessage;
import com.hhovhann.chatbackendapi.chatmessage.repository.ChatMessageRepository;
import com.hhovhann.chatbackendapi.chatroom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatRoomService chatRoomService;
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage save(ChatMessage chatMessage) {
//        TODO
//        4) Start 1:1 Chat Message
//        - Allow users to start chatting with someone they find.
//        - Use WebSocket for live text messaging (no images or multimedia yet).

        var chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(); // throw custom error message ..... ..... .... //

        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);

        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
//        TODO
//        5) Show All Message History
//        - Save chat messages in a database.
//                - Let users see their chat history in an easy-to-read way.

        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);

        return chatId.map(chatMessageRepository::findByChatId)
                .orElse(Collections.emptyList());
    }

}
