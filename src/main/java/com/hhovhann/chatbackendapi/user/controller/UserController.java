package com.hhovhann.chatbackendapi.user.controller;

import com.hhovhann.chatbackendapi.user.document.User;
import com.hhovhann.chatbackendapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MessageMapping("user.addUser")
    @SendTo("/user/topic")
    public User signup(@Payload User user) {
        userService.signUp(user);
        return user;
    }

    @MessageMapping("user.disconnectUser")
    @SendTo("/user/topic")
    public User disconnect(@Payload User user) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/api/v1/users/search")
    public ResponseEntity<User> findAllByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }

}
