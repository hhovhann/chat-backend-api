package com.hhovhann.chatbackendapi.user.document;

import com.hhovhann.chatbackendapi.user.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class User {
    @Id
    @Indexed(unique = true)
    private String username;
    private String password;
    @Indexed(unique = true)
    private String email;
    private String name;
    private Status status;
}
