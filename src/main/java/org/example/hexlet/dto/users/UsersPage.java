package org.example.hexlet.dto.users;

import lombok.Getter;
import org.example.hexlet.dto.Page;
import org.example.hexlet.model.User;

import java.util.List;


@Getter
public class UsersPage extends Page {
    private List<User> users;
    private String term;

    public UsersPage(String header, List<User> users, String term) {
        super(header);
        this.users = users;
        this.term = term;
    }
}
