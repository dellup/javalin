package org.example.hexlet.dto.users;

import lombok.Getter;
import org.example.hexlet.dto.Page;
import org.example.hexlet.model.User;

@Getter
public class UserPage extends Page {
    private User user;

    public UserPage(String header, User user) {
        super(header);
        this.user = user;
    }
}
