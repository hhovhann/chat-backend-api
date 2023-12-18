package com.hhovhann.chatbackendapi.user.service;

import com.hhovhann.chatbackendapi.user.document.User;
import com.hhovhann.chatbackendapi.user.enums.Status;
import com.hhovhann.chatbackendapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signUp(User user) {
//      TODO
//        1) User Registration
//        - Add a feature for users to sign up with their email, name, password, and a unique username.
//        - Ensure the email and username are not already taken.
        log.debug("signUp, user: {}", user);

        user.setStatus(Status.ONLINE);
//        TODO VALIDATION: - Ensure the email and username are not already taken.
//        if (userRepository.existsById(user.getUsername()) || userRepository.existsById(user.getEmail())) {
//            throw new RuntimeException("The user with the username or email already exist");
//        }

        return userRepository.save(user);
    }

    public void login(User user) {
        log.debug("login, user: {}", user);
//       TODO
//       2) User Login
//        - Create a login system where users can sign in with their email and password.
//        - Set up a way to keep users logged in.

    }

    public void disconnect(User user) {
        log.debug("disconnect, user: {}", user);

        var storedUser = userRepository.findById(user.getUsername()).orElse(null);
        if (Objects.nonNull(storedUser)) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(user);
        }
    }

    public User findByUsername(String username) {
        log.debug("findByUsername, username: {}", username);
//        TODO
//        3) Search for Other Users
//        - Make a simple search tool to find other users by their usernames.
//        - Focus on easy search and showing results.

        return userRepository.findByUsername(username);
    }

    public List<User> findConnectedUsers() {
        log.debug("findConnectedUsers");

        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
