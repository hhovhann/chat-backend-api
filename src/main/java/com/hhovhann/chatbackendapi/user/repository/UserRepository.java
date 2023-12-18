package com.hhovhann.chatbackendapi.user.repository;

import com.hhovhann.chatbackendapi.user.document.User;
import com.hhovhann.chatbackendapi.user.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);

    User findByUsername(String username);
}
